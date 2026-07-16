#include <stdio.h>

int main() {
    long num1, num2, sum;

    printf("Enter two long integers: ");
    scanf("%ld %ld", &num1, &num2);

    sum = num1 + num2;

    printf("Sum = %ld\n", sum);

    return 0;
}