#include <iostream>
// Returns a hash code based on an address
//���ֹ�ϣ��˼��
using namespace std;
unsigned short Hash( void *p ) {
	unsigned int val = reinterpret_cast<unsigned int>( p );  //���д����ַ��ת����int����
	cout << val << " -- "; 
	return ( unsigned short )( val ^ (val >> 16));     // ��val���� λ���� �� �������
}


int main() {
	int a[20] = {0};
	for ( int i = 0; i < 20; i++ )
		cout << Hash( a + i ) << endl;  //��������ʵ����ָ��ָ���һ��Ԫ�ص�ַ
}

//�������һ����64λ��ϵͳ��������Ҫ��unsigned int�ĳ� unsigned long�������С�
