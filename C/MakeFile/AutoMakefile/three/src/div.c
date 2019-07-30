#include "../include/div.h"
#include <stdio.h>

int divide(int x, int y){
    if(x % y != 0)
        printf("\nWarning: Integer Division May Have Accuracy Loss.\n");
    return x / y;
}
