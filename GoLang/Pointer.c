#include<stdio.h>
void chnage(int *x){
    *x=100;
}


int main(){
printf("hello world\n");

int age=22;
printf("%p\n",&age);

int Age=23;
int *ptr=&Age;

*ptr=77;

chnage(&Age);
printf("%p\n",ptr);
printf("ag is %d\n",Age);

int arr[5]={10,20,30,40,50};
printf("the address of first element %p\n ",&arr[0]);
printf("%p\n",arr);
    return 0;
}