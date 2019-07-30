#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include "sum.h"   //调用头文件
#include "sub.h"
#include "mul.h"
#include "div.h"

int main()
{
    printf("======== < Integer Arithmethic > ========\n");
    int x, y;
    printf("Enter two integer: ");
    scanf("%d%d", &x, &y);
    int sm = sum(x, y);
    printf("sum is: %d\n", sm);
    int sb = sub(x, y);
    printf("sub is: %d\n", sb);
    int ml = mul(x, y);
    printf("mul is: %d\n", ml);
    int dv = divide(x, y);
    printf("div is: %d\n", dv);
    return 0;
}
