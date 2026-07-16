#include<stdio.h>
#include<limits.h>


void chnage(int *x){
    *x=100;
}



long sum(long a,long b){
    long res=a+b;
    return res;
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

int res=sum(3,4);
printf("%d\n",res);

int res2=Newsum(102929292929292,29292929292);

printf("%d\n",res2);
    return 0;
}