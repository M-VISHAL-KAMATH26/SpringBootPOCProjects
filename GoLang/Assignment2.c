#include <stdio.h>
#include <stdlib.h>

int main() {
    int rows = 3;

    // Array of pointers
    int **arr = (int **)malloc(rows * sizeof(int *));

    // Different number of columns in each row
    int cols[] = {1, 2, 3};

    // Allocate memory for each row
    for (int i = 0; i < rows; i++) {
        arr[i] = (int *)malloc(cols[i] * sizeof(int));

        for (int j = 0; j < cols[i]; j++) {
            arr[i][j] = i + j;
        }
    }

    // Print
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols[i]; j++) {
            printf("%d ", arr[i][j]);
        }
        printf("\n");
    }

    // Free memory
    for (int i = 0; i < rows; i++)
        free(arr[i]);

    free(arr);

    return 0;
} 