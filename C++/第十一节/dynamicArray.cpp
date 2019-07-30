#include <iostream>
/**动态数组案例**/

int main(void){

    unsigned int num;
    std::cout << "请输入一个整数规定该数组的长度：";
    std::cin  >> num;

    //申请内存空间
    int *px = new int[num];
    //数组的使用形式
    for(int i=0; i < num; i++){
        px[i] = i;
    }

    for(int i = num - 1; i >= 0; i--){
        //指针的使用形式
        std::cout << "px[" << i << "]的值为：" << *(px+i) << std::endl;
        std::cout << "px[" << i << "]的值为：" << (*px+i) << std::endl;
    }
    //别忘记删除
    delete []px;
    std::cout << "END";
    return 0;
}
