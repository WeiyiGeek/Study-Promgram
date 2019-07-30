#include <fstream>
#include <iostream>

using namespace std;
int main(){
	//×·¼ÓÄ£Ê½ 
	ofstream out("test.txt",ios::app);
	if(!out){
		cerr << "Open File Fail!\n" <<endl;
		return 0; 
	} 
	
	int i=9;
	while(i > 0){
		out << i;
		i--;
	}	
	cout << endl;
	out.close(); 
	system("type test.txt");
	return 0;
} 
