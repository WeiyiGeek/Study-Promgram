#include <iostream>
/**��������**/
// #���� 
class Lover {
public:
	Lover(std::string uName); 
	void kiss(Lover *lover);
	void ask(Lover *lover,std::string action);
	
protected:
	std::string name;
	friend class Others;  //����һ����Ԫ�� 
}; 

// #����
class Boy:public Lover{
public:
	Boy(std::string name);
};

class Girl:public Lover{
public:
	Girl(std::string name); 
}; 

// #��Ԫ�� 
class Others
{
public:
    Others(std::string tname);
    void kiss(Lover *lover);

protected:
    std::string name;
};


// #������
Lover::Lover(std::string uname){
	//���ڴ���Ĳ��������з������������thisָ�� 
	name = uname;
} 
Boy::Boy(std::string name):Lover(name){
} 
Girl::Girl(std::string name):Lover(name){
} 
Others::Others(std::string tname){
	name = tname;
	std::cout << "\n-----------"<< name <<"�ĳ��ִ������־���--------------- \n\n";
}


// # ����ķ����� (����Ķ���ĵ�ַ ֵ��ѧϰ) -- ���巽�������� 
void Lover::kiss(Lover *lover){
	std::cout << name << " �������Ǽҵ� " << lover->name << std::endl;
} 
void Lover::ask(Lover *lover,std::string dosome){
	std::cout << name << " �����Ǽҵ�" << lover->name << dosome << std::endl; 
}
void Others::kiss(Lover *lover){
	std::cout << name << " Ҳ����һ�� " << lover->name << " ��Ʈ��!\n";
} 

int main(void){
	
	Boy cool("С��");
	Girl beat("С��");
	//���ݶ��� 
	cool.kiss(&beat); 
	beat.ask(&cool,"ϴ��ɨ�أ�");
	Others there("С��");
	//��Ԫ������˻����protected���� 
	there.kiss(&cool); 
	return 0;
} 
