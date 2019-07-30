#include <stdio.h>

int main()
{
        int i = 5;

        while (i++)
        {
                if (i > 10)
                {
                        goto Label;
                }
        }

Label:  printf("Here, i = %d\n", i);

        return 0;
}
