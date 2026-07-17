#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
int *data;
int len;
int cap;
} IntSlice;

/* Equivalent of Go's appendInt */
IntSlice appendInt(IntSlice x, int y) {
    IntSlice z; 
    int zlen = x.len + 1;

    if (zlen <= x.cap) {
        /* Reuse existing array */
    z.data = x.data;
    z.len = zlen;
    z.cap = x.cap;
    } else {
        /* Allocate larger array */
    int zcap = zlen;
    if (zcap < 2 * x.len) {
    zcap = 2 * x.len;
    }
    if (zcap == 0) {
    zcap = 1;
    }
    z.data = (int *)malloc(zcap * sizeof(int));
    if (x.data != NULL && x.len > 0) {
    memcpy(z.data, x.data, x.len * sizeof(int));
    }

    z.len = zlen;
    z.cap = zcap;

    free(x.data);
    }

    z.data[x.len] = y;
    return z;
}

void printSlice(IntSlice s) {
    printf("[");
    for (int i = 0; i < s.len; i++) {
    printf("%d", s.data[i]);
    if (i < s.len - 1) {
    printf(" ");
    }
    }
    printf("]");
}

void playWithAppendInt() {
    IntSlice x = {NULL, 0, 0};
    IntSlice y;

    for (int i = 0; i < 10; i++) {
    y = appendInt(x, i);

    printf("%d Capacity = %d \t", i, y.cap);
    printSlice(y);
    printf("\n");

    x = y;
    }

    free(x.data);
}

/* Equivalent of Go's playwithsomething() */
void playwithsomething() {
    int rows = 3;

    int **something = (int **)malloc(rows * sizeof(int *));
    int *lengths = (int *)malloc(rows * sizeof(int));

    for (int i = 0; i < rows; i++) {
    int innerLen = i + 1;
    lengths[i] = innerLen;

    something[i] = (int *)malloc(innerLen * sizeof(int));

    for (int j = 0; j < innerLen; j++) {
    something[i][j] = i + j;
    }
    }

printf("[\n");
for (int i = 0; i < rows; i++) {
printf("  [");
for (int j = 0; j < lengths[i]; j++) {
printf("%d", something[i][j]);
if (j < lengths[i] - 1) {
printf(" ");
}
    }
    printf("]\n");
    }
    printf("]\n");

for (int i = 0; i < rows; i++) {
free(something[i]);
}
free(something);
free(lengths);
}

int main() {
printf("\nFunction: playWithAppendInt\n");
playWithAppendInt();

printf("\nFunction: playwithsomething\n");
playwithsomething();

return 0;
}