#include <stdio.h>
#include <stdlib.h>

int global_var1;  //全局变量,extern属性
int global_var2;
static int file_static_var1;  //internal属性:只在一个文件中使用
static int file_static_var2;

void func1(int func1_param1, int func1_param2)
{
        static int func1_static_var1;
        static int func1_static_var2;
        int func1_var1;
        int func1_var2;

        // 输出行参的地址
        printf("addr of func1_param1: %010p\n", &func1_param1);
        printf("addr of func1_param2: %010p\n", &func1_param2);

        // 输出静态局部变量的地址
        printf("addr of func1_static_var1: %010p\n", &func1_static_var1);
        printf("addr of func1_static_var2: %010p\n", &func1_static_var2);

        // 输出func1局部变量的地址
        printf("addr of func1_var1: %010p\n", &func1_var1);
        printf("addr of func1_var2: %010p\n", &func1_var2);
}


void func2(const int func2_const_param1, const int func2_const_param2)
{
        int func2_var1;
        int func2_var2;

        // 输出const参数的地址
        printf("addr of func2_const_param1: %010p\n", &func2_const_param1);
        printf("addr of func2_const_param2: %010p\n", &func2_const_param2);

        // 输出func2局部变量的地址
        printf("addr of func2_var1: %010p\n", &func2_var1);
        printf("addr of func2_var2: %010p\n", &func2_var2);
}

int main(void)
{
        char *string1 = "I love FishC.com";
        char *string2 = "very much";

        // 输出函数的地址
        printf("addr of func1: %010p\n", func1);
        printf("addr of func2: %010p\n", func2);

        // 输出字符串常量的地址
        printf("addr of string1: %010p\n", string1);
        printf("addr of string2: %010p\n", string2);

        // 输出文件内的static变量的地址
        printf("addr of file_static_var1: %010p\n", &file_static_var1);
        printf("addr of file_static_var2: %010p\n", &file_static_var2);

        // 输出全局变量的地址
        printf("addr of global_var1: %010p\n", &global_var1);
        printf("addr of global_var2: %010p\n", &global_var2);


        // 输出函数内局部变量的地址
        func1(1, 2);
        func2(3, 4);

        return 0;
}
