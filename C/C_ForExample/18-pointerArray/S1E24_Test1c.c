#include <stdio.h>

int main()
{
        char matrix[3][5] = {
                'I', 'l', 'o', 'v', 'e',
                'F', 'i', 's', 'h', 'C',
                '.', 'c', 'o', 'm', '!'
        };
        char *p;

        p = &matrix[0][3];

       /* printf("%c", *p);  //v 
        printf("%c", *p++);  //v(还是本身) - >（下一次为） [0][4]
        printf("%c", *++p;  //上面的 +1 -> [1][0]
        printf("\n");*/
		printf("*(matrix+1)+2: %p\n",*(matrix+1)+2);
		printf("matrix[1][2]: %p\n"),&matrix[1][2];
        return 0;
}
