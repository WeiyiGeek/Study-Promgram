#include <stdio.h>
#include <stdbool.h>

#define NUM 99

int main()
{
    bool isOdd;

    if (NUM % 2)
            isOdd = true;
     else
           isOdd = false;

    if (isOdd)
        printf("%d是奇数！\n", NUM);
    else
        printf("%d不是奇数！\n", NUM);
        
   return 0;
}
