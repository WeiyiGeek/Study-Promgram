#include <iostream>
/** C++ ������ʵ�� **/
class Pet{
public:
    Pet(std::string xm);
    std::string name;
    virtual void play() = 0;  //�������麯�������󷽷���- ���Լ��ٴ����������ڲ���Ҫ�ڻ����н��ж���÷�����Ϊ
};
class Cat:public Pet{
public:
    Cat(std::string xm);
    //è����ˣ����

    void play(){
        std::cout << name << "������ë���򣡣���\n";
    }
};
class Dog:public Pet{
public:
    Dog(std::string xm);
    //������ˣ����
    void play(){
        std::cout << name << "���ں�����һ�����򣡣���\n";
    }
};

//������
Pet::Pet(std::string xm){
    name = xm;
}
Cat::Cat(std::string xm):Pet(xm){
}
Dog::Dog(std::string xm):Pet(xm){
}

int main(void){
    //��ʵ��������
    Cat mm("Сèè");
    Pet *cPt = &mm;  //�е�������ֱ�� new һ�� Cat����
    cPt -> play();
    delete cPt;  //ͬ��ɾ���ڴ�ռ��ַ

    //����new / delete
    Pet *dPt = new Dog("����");
    dPt -> play();
    delete dPt;

    std::cout << "\nһ��Ĺ������\n";
    return 0;
}
