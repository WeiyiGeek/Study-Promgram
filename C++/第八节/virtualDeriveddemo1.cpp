#include <iostream>
/** ̽���������ǲ����麯�� */

class ClxBase
{
public:
    //ע�⹹�������������������ó��󷽷�
    ClxBase(){}; //���๹�����ǿպ���
    virtual ~ClxBase(){};  //�����������ǿպ���
    virtual void doSomething()
    {
        std::cout << "1.Do something in class ClxBase!\n";  //����
    }
};

class ClxDerived : public ClxBase
{
public:
    ClxDerived(){
    };
    ~ClxDerived(){
        std::cout << "3.Output ����������� ���������ڴ�ռ� \n";
    };
    void doSomething()
    {
        std::cout << "2.Do something in class ClxDerived!\n"; //����
    };
};

int main()
{
    //����ָ����ʽ
    ClxBase *pTest = new ClxDerived;
    pTest -> doSomething();
    delete pTest;

    std::cout << "\n-------------- �ָ��� ------------\n\n";

    //����ʵ�����������ʽ
    ClxDerived demo;
    demo.doSomething();

    return 0;
}
