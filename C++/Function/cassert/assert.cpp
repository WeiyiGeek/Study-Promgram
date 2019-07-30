#include <iostream>
#include <cassert>
/**断言异常处理**/

int main(void){
    int num = 0;
    std::cout << "请输入一个数字：";
    std::cin >> num;
    assert(num>10);
    if(1){
        std::cout << "恭喜您没有异常！";
    }else{
        std::cout << "程序崩了!";
    }
    return 0;
}
