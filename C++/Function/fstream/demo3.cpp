#include <fstream>
#include <iostream> 
using namespace std;

int main() {
	
	//直接上fstream类对象
	fstream io("test.txt",ios::in|ios::out); 
	if(!io){
		cerr << "Error" << endl;
		return 0; 
	}
	
	io << "I-love-C++-PROGRAM-Language!";
	//值得注意的地方下面必须是静态的 
	static char test[100];
	
	io.seekg(ios::beg); //指向文件开头 
	
	while(io >> test)
		; 
	//空格之前的字符串不显示 
	cout << test << endl;	
	io.close();
	return 0; 
}
