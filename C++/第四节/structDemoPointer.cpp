#include <iostream>
#include <fstream>
/**
	���ýṹ��ָ��ʵ��ѧ���ɼ���
	1.��ȡ���ն�
	2.д�뵽�ļ�
	3.¼����Ϣ 
**/ 

using namespace std;
//�ṹ��������һ������ĸ��д 
struct Demo {
		string name;
		int uid;
		char sex;		 
} studyy;

bool Init(void);
bool Read(void);
bool Write(Demo *stuData);

int main(void){
	if(Init()){
		cerr  << "��ʼ������ʧ��!!!" << endl;
		return 1; 
	}
	int xh;
	while(1){
		cout << "��ѡ��ѧ����Ϣ����ϵͳ���ܣ�\n (1)��ȡѧ����Ϣ \n (2)д��ѧ����Ϣ \n (3)�˳����� " << endl; 
		cout << "�������ţ�"; 
		cin >> xh;
		cout << endl;
		
		switch(xh){	
			case 1:
				if(Read()){
					cerr << "��ȡʧ�ܣ�����" << endl; 
				}
				break;
			case 2:
				
				cout << "����������";
				cin >> studyy.name;
				cout << "����ѧ�ţ�";
				cin >> studyy.uid;
				cout << "�����Ա�"; 
				cin >> studyy.sex;			 
				Write(&studyy);
				break;
			case 3:
				cout << " <<--���˳�����-->> " << endl; 
				return 1;
			default:
				cerr << " ���������������������<1,2,3> " << endl; 
		}
		cout << "\n" << endl; 
	} 
	
	return 0; 
} 

//��ʼ������
bool Init(void){
	//д����ļ� 
	ofstream out("test.txt"); 
	//������0ʱ���ʧ��
	if(!out){
        //��׼������
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	} 
	
	Demo study = {"Weiyi",20180101,'f'};
	out << study.name << " " << study.uid << " " << study.sex << "\r\n" << endl;
	out.close();
	return 0; 
} 

//��ȡ���� 
bool Read(void){
	ifstream in("test.txt");
	if(!in){
		 //��׼������
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	}
	
	string info;
	int i=1;
	while(in >> info){
		cout << info << " "; 
		if(i % 3 == 0){
			cout << "\n";
		}
		i++;
	}
	cout << endl;
	in.close();
	return 0;
}

//����ָ��д�� 
bool Write(Demo *stuData){
//д����ļ� 
	ofstream out("test.txt",ios::app); 
	//������0ʱ���ʧ��
	if(!out){
        //��׼������
		cerr << "Open Fail!!\n" << endl;
		return 1; 
	} 

	out << stuData->name << " " <<stuData->uid << " " << stuData->sex << "\r\n" << endl;
	out.close();
	
	return 0; 

}
