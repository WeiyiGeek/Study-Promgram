#include <iostream>
/**����C++������������ۼ�**/ 
using namespace std;
int arrayAdd(int *array,int length);  

int main(void){
	
	int array[] = {1,2,3,4,5,6,7,8,9,0};  //ռ��40�ֽ� 
	int len = sizeof(array) / sizeof(array[0]); //ȡ������� 
	cout << "C++�﷨:���� 0..9 ֮��Ϊ=" << arrayAdd(array,len) << endl; 
	return 0;
} 

int arrayAdd(int *array,int length){
	int sum = 0,i = 0;
	for(; i < length; i++){
		sum += *array++;  //arrayֻռ��4�ֽ�(��һ��ָ��) 
	}
	return sum; 
}

