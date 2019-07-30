#include <iostream>
#include <climits>

/**采用了try catch **/
//表示当函数执行的时候返回值若是一个字符类型的
unsigned long returnFactorial(unsigned short num) throw (const char *);

int main()
{
    unsigned short num = 0;
    std::cout << "请输入一个整数: ";
    while( !(std::cin>>num) || (num<1) )
    {
        std::cin.clear();             // 清除状态
        std::cin.ignore(100, '\n');   // 清除缓冲区
        std::cout << "请输入一个整数：";
    }
    std::cin.ignore(100, '\n');

    try
    {
        unsigned long factorial = returnFactorial(num);
        std::cout << num << "的阶乘值是: " << factorial;
    }
    catch(const char *e)
    {
        //当函数执行的时候返回值若是一个字符类型的
        std::cout << "异常抛出！\n";
        std::cout << e;
    }
    return 0;
}

unsigned long returnFactorial(unsigned short num) throw (const char *)
{
    unsigned long sum = 1;
    unsigned long max = ULONG_MAX;
    //值得学习
    for( int i=1; i <= num; i++ )
    {
        sum *= i;
        max /= i;
    }

    if( max < 1 )
    {
        throw "悲催！！！该基数太大，无法在该计算机计算求出阶乘值。\n";
    }
    else
    {
        return sum;
    }
}
