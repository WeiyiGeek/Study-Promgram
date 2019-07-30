#include <iostream>
#include <string>
#include <fstream>
/**
	构造器与析构器的使用 
**/
using namespace std;
//声明类 
class Store{
	//不要忘记这个关键词修饰符 
	public:  
		string book,author;
		ofstream fillOutput;
		
		//构造器与析构器 分别打开和关闭的文件 
		Store();
		~Store();
	
		void inputBook();
		void inputAuthor();
		bool write(); 
	 
}; 

//构造器 
Store::Store(){
	fillOutput.open("test.txt",ios::app); //写入文件末尾追加的方式 
} 

//析构器 
Store::~Store(){
	fillOutput.close();
} 
 
void Store::inputBook(){
	getline(cin,book); //写入我们的 book属性字符串中 
} 
void Store::inputAuthor(){
	getline(cin,author); //写入我们的 author属性 符串中 
}

bool Store::write(){
	//判断文件是否打开  值得学习 
	if(fillOutput.is_open()){
		fillOutput << book << " | " << author << endl;
		return true;
	}else{
		return false; 
	}
}
 
int main(void){
	Store books;
	cout << "请输入书的名字：";
	books.inputBook();
	
	cout << "请输入书的作者：";
	books.inputAuthor();
	
	if(books.write()){
		cout << "@ 写入文件成功！" << endl;
	}else{
		cout << "！写入文件失败！" << endl;
	}
	
	
	return 0; 
} 
