#include <iostream>
#include <string>
/**��̳�**/

class Pet{
public:
    Pet(std::string na,unsigned short ag){
        name = na;
        age = ag;
    }
   void demo(){
        std::cout << "Pet My Name:" << name << " , Age " << age;
    }
protected:
    std::string name;
    unsigned short age;

};

class Cat:public Pet{
public:
    Cat(std::string na,unsigned short ag):Pet(na,ag){}
    void demo(){
        std::cout << "Cat | My Name:" << name << " , Age " << age;
    }
};
//��̳�
class Dog:virtual public Pet{
public:
    Dog(std::string na,unsigned short ag):Pet(na, ag){}
    void demo(){
        std::cout << "\nDog | My Name:" << name << " , Age " << age;
    }
};

class Others:public Cat,public Dog{
public:
    Others(std::string na,unsigned short ag):Cat(na,ag),Dog(na,ag),Pet(na,ag){
    }
    void demo(){
        std::cout << "\nOthers DEMO();";
    }
};

int main(void){

    Cat ca("ëë",5);
    ca.demo();
    std::cout << "\n";
    //����new�������
    Pet *dp = new Dog("����",5);
    dp -> demo();
    delete dp;

    //��̳�
    Others oth("Others",100);
    oth.demo();
    return 0;
}
