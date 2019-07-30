#include <iostream>
#include <climits>
/**
����C++���д������
����13�Ľ׳˳���ϵͳ���ֵ
**/
class Factorial{
public:
    Factorial(unsigned short num){
        this->num = num;
    }
    //����׳˵ķ���
    unsigned long factorial(){
        unsigned long res = 1;
        for(int i = 1; i <= num; i++){
                res *= i;
        }
        return res;
    }
    //���ؽ׳�ֵ�Ƿ��ڷ�Χ
    bool validate(){
        //�޷��� ������ long max
        unsigned long max = ULONG_MAX;
        for(unsigned short i = num; i >= 1; i--){
            max /= i;  //���max����һ��С��1��˵��num�׳˴���ULONG_MAX , ����׳˵�����ULONG_MAX��Χ��
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
        std::cout << "������һ���������������Ľ׳ˣ�";
        std::cin >> num;
        Factorial demo(num);
        if(demo.validate()){
            std::cout << num << "�׳�Ϊ��" << demo.factorial() << std::endl;
        }else{
            std::cout << "��ǰ��������׳�̫���ˣ�ϵͳ����ʾ��������\n" << std::endl;
            break;
        }
    }



    return 0;
}



