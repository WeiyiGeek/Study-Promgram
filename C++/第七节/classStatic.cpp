#include <iostream>
#include <string>
/** ��� ��̬�����뷽�� **/ 

class Pet{
public:
    Pet(std::string theName);
    ~Pet();

    static int getCount(); //��̬���� 

protected:
    std::string name;

private:
    static int count; //��̬���� 
};

class Dog : public Pet
{
public:
    Dog(std::string theName);
};

class Cat : public Pet
{
public:
    Cat(std::string theName);
};

//��̬���� ����ֱ������ 
int Pet::count = 0;         // ע����һ�䣺����������������  ��1�����ڴ��ڷ����ַ ��2����ʼ����count����ֵ 
//����Ĺ������������� 
Pet::Pet(std::string theName)
{
    name = theName;
    count++; //��̬�������¼ÿ��countֵ�ı仯 
    std::cout << "���������,���ֽ���: " << name << "\n";
}
Pet::~Pet()
{
    count--;
    std::cout << name << ":�Ѿ��ҵ���\n";
}
int Pet::getCount()
{
    return count;  // Ϊ�˷�������˽�е�count���� �������ķ��� 
}
//����Ĺ����� 
Dog::Dog(std::string theName) : Pet(theName){
}
Cat::Cat(std::string theName) : Pet(theName){
}

int main()
{
    Dog dog("С��");
    Cat cat("С��");
								//��̬���� ����ֱ������ 
    std::cout << "\n�Ѿ�������" << Pet::getCount() << "ֻ����!\n\n";
	//ע���������������->����������������������ڵ����� 
	{
		Dog dog_2("Tom_��");
        Cat cat_2("Jerry_��");
        std::cout << "\n����һ��������" << Pet::getCount() << "ֻ����!\n\n";		
	}

    std::cout << "\n���ڻ�ʣ�� " << Pet::getCount() << " ֻ����!\n\n";
    return 0;
}
