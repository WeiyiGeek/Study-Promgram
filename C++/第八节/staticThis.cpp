#include<iostream>
/**��̬���� �� this ָ�� Demo**/
class Point
{
private:
	int x, y;
//����ֱ������������з�������������
public:
	Point(int a, int b)
	{ 
		x = a;
		y = b;
	}
	void MovePoint( int a, int b)
	{ 
		x = a; 
		y = b;
	}
	void print()
	{ 
		std::cout << "x=" << x << " , y=" << y << std::endl;
	}
};

int main()
{
	Point point1(10, 10); 
	point1.print();
	point1.MovePoint(2, 2);  // ������point1����MovePoint(2,2)����ʱ������point1����ĵ�ַ���ݸ���thisָ�롣
	// MovePoint������ԭ����ʵ��Ӧ���� void MovePoint( Point *this, int a, int b);
	// ��һ��������ָ���������һ��ָ�룬�����ڶ����Ա����ʱû��������Ϊ��������������������ġ�
	point1.print();
	// ����point1�ĵ�ַ���ݸ���this��������MovePoint�����б������ʽ��д�ɣ�void MovePoint(int a, int b) { this->x = a; this->y = b;} 
	// ������֪����point1���øú�����Ҳ����point1�����ݳ�Ա�����ò�������ֵ��
	return 0;
}




