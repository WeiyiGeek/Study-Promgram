#include <iostream>
/**
C++���������󼸸�����֮��(ע�����Ľ�׳��)
**/
 
int main(void){
 	//Ϊ�˳����ͨ���� ���ֲ�������ջ���棩 
	const unsigned short ITEM = 5; 
	int arr[ITEM];
	//std������ 
	std::cout << "��" << ITEM << "�������֮��;\n" << std::endl; 
	for(int i = 0 ; i < ITEM ; i++){ 
		std::cout << "�������" << i <<"��ֵ��";
		// 0 1  ��ȡ���󷵻�0 
		// 1 0  �ɹ��򷵻ط�0 
		while(!(std::cin >> arr[i])){
			std::cin.clear();  //��������
			std::cerr << "������������������\n"; 
		} 	
	}
	
	//ע��ֲ�����һ��Ҫ��ʼ������������ָһ����ַ 
	int res = 0; 
	for(int i = 0; i < ITEM; i++){
		res += arr[i];
	} 
	std::cout << "�������֮��Ϊ��" << res << "\n";
	std::cout << "ƽ��ֵΪ��" << (float)res / ITEM << "\n"; 
	return 0;
}
