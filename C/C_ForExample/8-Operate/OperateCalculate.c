#include <stdio.h>

int main()
{
    int a;
    (a = 2) + 3 * 4;  //由于优先级所以直接a=2 
    printf("a = %d\n", a);

printf("A = %.6f\n", (float)(5/3));
printf("C = %.6f\n", 1.2+3);
printf("D = %.6f\n", 1.2*0);
printf("E = %.6f\n", 6.0/2);
printf("F = %.6f\n", 10/6.0);
printf("G = %.6f\n", (float)(3/5));



}
