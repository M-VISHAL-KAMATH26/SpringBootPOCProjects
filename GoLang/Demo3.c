#include<stdio.h>


int main(){

int arr[]={10,20,30,40,50};
int size=5;
int *ptr=arr;

printf("%d\n",*ptr);

printf("printing the array elements using the pointers\n");
for(int i=0;i<size;i++){
    printf("%d\n",ptr[i]);
}

printf("printing the address of the elements in the array\n");
for(int i=0;i<size;i++){
    printf("%p\n",ptr+i);
}

printf("printing the values of the array using pointer\n");
for(int i=0;i<size;i++){
    printf("%d\n",*(ptr+i));
}



return 0;
}