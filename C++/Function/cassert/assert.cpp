#include <iostream>
#include <cassert>
/**�����쳣����**/

int main(void){
    int num = 0;
    std::cout << "������һ�����֣�";
    std::cin >> num;
    assert(num>10);
    if(1){
        std::cout << "��ϲ��û���쳣��";
    }else{
        std::cout << "�������!";
    }
    return 0;
}
