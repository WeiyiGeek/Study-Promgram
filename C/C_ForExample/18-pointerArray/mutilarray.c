#include <stdio.h>
int main(){
        char array[2][3][5] = {   //2������, ÿ����������,5�� 
                {
                        {'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'o', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x'}
                },
                {
                        {'x', 'x', 'x', 'x', 'x'},
                        {'x', 'x', 'o', 'x', 'x'},
                        {'x', 'x', 'x', 'x', 'x'}
                }
        };

        printf("%c%c%c%c\n", *(*(*array + 1) + 2), *(*(*(array + 1) + 1) + 2), ***array, *(**array + 1));
        return 0;
}
