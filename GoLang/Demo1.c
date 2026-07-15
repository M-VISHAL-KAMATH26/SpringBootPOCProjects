#include<stdio.h>

void printArray(){
    int arr[]={1,2,3,4,5,6};
    for(int i=0;i<100;i++){
        printf("%d\n",arr[i]);
    }
}
int main(){
printArray();
int aa[]={10,20};
int bb[]={10,20};
printf("%d\n",aa==bb);


int numbers[]={10,20,30,40,50};
int *numbersCopy =numbers;

numbers[0]=111;
numbers[4]=444;

printf("%d\n",numbersCopy[0]);

    return 0;
}