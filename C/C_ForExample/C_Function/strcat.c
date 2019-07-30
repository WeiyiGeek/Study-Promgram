#include <stdio.h>
#include <string.h>

int main()
{
        char str1[100] = "Original String";
        char str2[] = "New String";

        strcat(str1, ",ADD First ");
            printf("First-str1: %s\n", str1);

        strcat(str1, str2);
      	    printf("second-str1: %s\n", str1);

        return 0;
}
