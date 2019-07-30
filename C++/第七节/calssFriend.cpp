#include <iostream>
/**需求如上**/
// #基类 
class Lover {
public:
	Lover(std::string uName); 
	void kiss(Lover *lover);
	void ask(Lover *lover,std::string action);
	
protected:
	std::string name;
	friend class Others;  //声明一个友元类 
}; 

// #子类
class Boy:public Lover{
public:
	Boy(std::string name);
};

class Girl:public Lover{
public:
	Girl(std::string name); 
}; 

// #友元类 
class Others
{
public:
    Others(std::string tname);
    void kiss(Lover *lover);

protected:
    std::string name;
};


// #构造器
Lover::Lover(std::string uname){
	//由于传入的参数与类中方法重名则采用this指针 
	name = uname;
} 
Boy::Boy(std::string name):Lover(name){
} 
Girl::Girl(std::string name):Lover(name){
} 
Others::Others(std::string tname){
	name = tname;
	std::cout << "\n-----------"<< name <<"的出现打破了林静！--------------- \n\n";
}


// # 定义的方法： (传入的对象的地址 值得学习) -- 定义方法的类型 
void Lover::kiss(Lover *lover){
	std::cout << name << " 亲亲我们家的 " << lover->name << std::endl;
} 
void Lover::ask(Lover *lover,std::string dosome){
	std::cout << name << " 叫他们家的" << lover->name << dosome << std::endl; 
}
void Others::kiss(Lover *lover){
	std::cout << name << " 也亲了一哈 " << lover->name << " 心飘了!\n";
} 

int main(void){
	
	Boy cool("小明");
	Girl beat("小红");
	//传递对象 
	cool.kiss(&beat); 
	beat.ask(&cool,"洗碗扫地！");
	Others there("小粉");
	//友元类调用了基类的protected属性 
	there.kiss(&cool); 
	return 0;
} 
