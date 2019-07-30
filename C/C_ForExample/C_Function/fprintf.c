#include <stdio.h>
#include <stdlib.h>

int main()
{
    FILE *fp;
    char strbuf[16] = "Fprintf() Demo";
    if((fp = fopen("fwrite.txt","w+b")) == NULL)
    {
      fprintf(stderr, "Can not open inputfile.\n");
      return 1;
    }
    fprintf(fp,"%s\n",strbuf);
    fclose(fp);
    system("whoami"); //执行系统命令的函数在stdlib.h中
  return 0;
}
