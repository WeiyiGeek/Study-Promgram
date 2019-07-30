#include <iostream>
#include <string>
/** 内联模板模板展示 - 栈的进出优化 **/


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

     //T代表任意类型
    T push(T value){ //使用 内联函数 再也不需要 外部定义的方法都需要加上 template 模板声明
        if(sp >= size)
        {
            std::cout << "栈溢出了！\n";
            return -1;
        }
         data[sp++] = value;
    }

    T pop(){
        if((--sp) < 0)
        {
            std::cout << "栈是空的！不能弹出！\n";
            sp = 0;
            return -1;
        }
       return data[sp]; //注意这里先--在赋值 (实际最后一次压栈,sp指针指向栈顶) 弹栈就要将sp指向栈顶下的数据项
    }
protected:
    unsigned int size;
    int sp;
    T *data;
};



int main(void){

    Stackc<short> intstack(3);  //注意这里加上了 构造函数数据类型(重要)
#if 0
    intstack.push(1);
    intstack.push(2);
    intstack.push(3);
    intstack.push(4);
#endif
    std::cout << "push: " << intstack.pop() << "\n";
    return 0;
}

