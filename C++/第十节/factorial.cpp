#include <iostream>
#include <climits>
/**
采用C++进行错误调试
计算13的阶乘超出系统最大值
**/
class Factorial{
public:
    Factorial(unsigned short num){
        this->num = num;
    }
    //计算阶乘的方法
    unsigned long factorial(){
        unsigned long res = 1;
        for(int i = 1; i <= num; i++){
                res *= i;
        }
        return res;
    }
    //返回阶乘值是否在范围
    bool validate(){
        //无符号 最大的数 long max
        unsigned long max = ULONG_MAX;
        for(unsigned short i = num; i >= 1; i--){
            max /= i;  //如果max返回一个小于1则说明num阶乘大于ULONG_MAX , 否则阶乘的数在ULONG_MAX范围内
        }
        if(max < 1){
            return false;
        }else{
            return true;
        }
    }
protected:
    unsigned short num;
};

int main(void)
{
    unsigned short num = 0;
    while(1){
        std::cout << "请输入一个正整数并求它的阶乘：";
        std::cin >> num;
        Factorial demo(num);
        if(demo.validate()){
            std::cout << num << "阶乘为：" << demo.factorial() << std::endl;
        }else{
            std::cout << "当前输入的数阶乘太大了，系统都显示不出来！\n" << std::endl;
            break;
        }
    }



    return 0;
}



