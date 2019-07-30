#include <iostream>
/**��ģ��չʾ - ջ�Ľ���*/

template <class T>
class Stackc{
public:
    Stackc(unsigned short size){
        this -> size = size;
        data = new T[size];     //���ݴ�С����new��
        sp = 0;
    }
    ~Stackc(){
        delete []data; //����delete
        data = NULL;
    }
    void push(T value);  //T��������
    T pop();
protected:
    unsigned int size;
    unsigned int sp;
    T *data;
};

//������ʵ�� (��Ҫ���巽�������ͣ��Լ�������������)
template <class T>  //�ⲿ����ķ�������Ҫ���� ģ������
void Stackc<T>::push(T value){
    data[sp++] = value;
}
//����һ����������
template <class T>
T Stackc<T>::pop(){
    return data[--sp]; //ע��������--�ڸ�ֵ (ʵ�����һ��ѹջ,spָ��ָ��ջ��) ��ջ��Ҫ��spָ��ջ���µ�������
}

int main(void){

    Stackc<short> intstack(100);  //ע����������� ���캯����������(��Ҫ)
    intstack.push(1);
    intstack.push(2);
    intstack.push(3);

    std::cout << "push: " << intstack.pop() << "\n";
    std::cout << "push: " << intstack.pop() << "\n";
    std::cout << "push: " << intstack.pop() << "\n";

    return 0;
}

