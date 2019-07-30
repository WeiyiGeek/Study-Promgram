#include <stdio.h>

int main(){
        int ch = 'A';
        int count = 3;

        while (count){
                ch = ch + count;  // +3 +2 +1
                count = count - 1;
                putchar(ch);
        }
        putchar('\n');
        return 0;
}
