#include <iostream>
/**类模板展示 - 栈的进出*/

template <class T>
class Stackc{
public:
    Stackc(unsigned short size){
        this -> size = size;
        data = new T[size];     //数据大小）（new）
        sp = 0;
    }
    ~Stackc(){
        delete []data; //必须delete
        data = NULL;
    }
    void push(T value);  //T代表类型
    T pop();
protected:
    unsigned int size;
    unsigned int sp;
    T *data;
};

//方法的实现 (需要定义方法的类型，以及方法参数类型)
template <class T>  //外部定义的方法都需要加上 模板声明
void Stackc<T>::push(T value){
    data[sp++] = value;
}
//返回一个任意类型
template <class T>
T Stackc<T>::pop(){
    return data[--sp]; //注意这里先--在赋值 (实际最后一次压栈,sp指针指向栈顶) 弹栈就要将sp指向栈顶下的数据项
}

int main(void){

    Stackc<short> intstack(100);  //注意这里加上了 构造函数数据类型(重要)
    intstack.push(1);
    intstack.push(2);
    intstack.push(3);

    std::cout << "push: " << intstack.pop() << "\n";
    std::cout << "push: " << intstack.pop() << "\n";
    std::cout << "push: " << intstack.pop() << "\n";

    return 0;
}

