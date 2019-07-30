#include <iostream>

/**���������� -- demo **/

//����
class Bcopy{
public:
    Bcopy(int *p){
        pt = p;
    }
    //���������� - ������ (��Ҫ) ���� Base demo3 = demo2; ��ʱ��ŵ��ø���������;
    Bcopy(const Bcopy &rhs){
        std::cout << "��Enter ������ - \n";
        *this = rhs; //���ƶ������ǰ�������غ��= �������ã�
        std::cout << "��Leave ������ ~ \n";
    }
    ~Bcopy(){
        std::cout << "@Enter/Leave ��ȡ�� @ \n";
        delete pt;
        pt = NULL;
    }
    //���� = ���ж�������ֵ���� (��Ҫ)
    Bcopy &operator=(const Bcopy &rhs){
        std::cout << "#Enter = ���� - \n";
        if(this != &rhs){
            delete pt;
            pt = NULL;
            pt = new int;
            *pt = *rhs.pt;  //��������pt�ĵ�ַ�����ֵ
        }else{
            std::cout << "������ͬ.����Copy��\n";
        }
        std::cout << "#Leave = ���� - \n";
        return *this;  //����ֵ��ע��
    }
    void print(){
        std::cout << "pt��" << *pt << "\n";
    }
protected:
    int *pt;
};

int main(void){
    //��ʽ1��
    Bcopy demo(new int(1024));
    Bcopy demo1(new int(512));
    demo1 = demo;
    demo.print();

    std::cout << "\n----------------------------------------\n\n";

    //��ʽ2��
    Bcopy demo2(new int(2048));
    Bcopy demo3 = demo2;
    demo3.print();

    //��ʽ3��
    std::cout << "\n----------------------------------------\n\n";
    Bcopy demo4(new int(2048));
    demo4 = demo4;
    demo4.print();

    return 0;
}
