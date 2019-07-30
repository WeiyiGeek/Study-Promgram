#include <stdio.h>

int main(){
       int a = 0x1234;
  	
       char *b = (char *)&a;
       printf("%d",sizeof(*b));
       printf("*b=%x\t *b-address=%p\n",*b,&(*b));
		printf("*(b+1)=%x\t*(b+1)=%p\n",*(b+1),&(*(b+1)));
        if (*b == 0x12)
        {
                printf("Big-Endian\n");
        }
        else
        {
                printf("Little-Endian\n");
        }

        return 0;
}
