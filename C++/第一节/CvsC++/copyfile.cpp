#include <fstream>
#include <iostream>

using namespace std;

int main(int argc, char** argv){
	
	if(argc != 3){
		cerr << "Uasge: " << argv[0] << " source Destication" << endl;
		return 1;
	}
	
	//读取文件名，写入的文件名 
	ifstream in(argv[1],ios::binary);
	ofstream out(argv[2],ios::binary);
	
	if(!in){
		cerr << "open file " << argv[1] << "Fail ！\n" << endl;
		return 1; 
		
	} else if(!out){
		cerr << "open file " << argv[2] << "Fail ！\n" << endl;
		//如果写入的文件打开失败则关闭读取的文件  
		in.close();
		return 1; 
	}
	
	char x;
	while(in >> x){
		out << x;
	} 

	if(in.eof()){
		cout << "文件复制成功!" << endl; 
	}else{
		cerr << "Fail" << endl; 
	}
	
	in.close();
	out.close();
	
	return 0;
}
