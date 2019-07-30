#include <iostream>
#include <string>
/** ����ģ��ģ��չʾ - ջ�Ľ����Ż� **/


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

     //T������������
    T push(T value){ //ʹ�� �������� ��Ҳ����Ҫ �ⲿ����ķ�������Ҫ���� template ģ������
        if(sp >= size)
        {
            std::cout << "ջ����ˣ�\n";
            return -1;
        }
         data[sp++] = value;
    }

    T pop(){
        if((--sp) < 0)
        {
            std::cout << "ջ�ǿյģ����ܵ�����\n";
            sp = 0;
            return -1;
        }
       return data[sp]; //ע��������--�ڸ�ֵ (ʵ�����һ��ѹջ,spָ��ָ��ջ��) ��ջ��Ҫ��spָ��ջ���µ�������
    }
protected:
    unsigned int size;
    int sp;
    T *data;
};



int main(void){

    Stackc<short> intstack(3);  //ע����������� ���캯����������(��Ҫ)
#if 0
    intstack.push(1);
    intstack.push(2);
    intstack.push(3);
    intstack.push(4);
#endif
    std::cout << "push: " << intstack.pop() << "\n";
    return 0;
}

