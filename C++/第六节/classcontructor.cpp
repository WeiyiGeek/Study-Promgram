#include <iostream>
#include <string>
#include <fstream>
/**
	����������������ʹ�� 
**/
using namespace std;
//������ 
class Store{
	//��Ҫ��������ؼ������η� 
	public:  
		string book,author;
		ofstream fillOutput;
		
		//�������������� �ֱ�򿪺͹رյ��ļ� 
		Store();
		~Store();
	
		void inputBook();
		void inputAuthor();
		bool write(); 
	 
}; 

//������ 
Store::Store(){
	fillOutput.open("test.txt",ios::app); //д���ļ�ĩβ׷�ӵķ�ʽ 
} 

//������ 
Store::~Store(){
	fillOutput.close();
} 
 
void Store::inputBook(){
	getline(cin,book); //д�����ǵ� book�����ַ����� 
} 
void Store::inputAuthor(){
	getline(cin,author); //д�����ǵ� author���� ������ 
}

bool Store::write(){
	//�ж��ļ��Ƿ��  ֵ��ѧϰ 
	if(fillOutput.is_open()){
		fillOutput << book << " | " << author << endl;
		return true;
	}else{
		return false; 
	}
}
 
int main(void){
	Store books;
	cout << "������������֣�";
	books.inputBook();
	
	cout << "������������ߣ�";
	books.inputAuthor();
	
	if(books.write()){
		cout << "@ д���ļ��ɹ���" << endl;
	}else{
		cout << "��д���ļ�ʧ�ܣ�" << endl;
	}
	
	
	return 0; 
} 
