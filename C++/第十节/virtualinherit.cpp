#include <iostream>
#include <string>
/**
��֤��̳���
virtual
**/
class Person{
public:
    //���๹����
    Person(std::string pname){
        name = pname;
        std::cout << "My Name is��" << name;
    }
protected:
    std::string name;
};

//�̳�Person�� ע����������̳�
class Teacher:virtual public Person{
public:
    //���๹���� ����1�����֣�����2:�����༶
    Teacher(std::string te,std::string cla):Person(te){
        classes = cla;
    }
    void introduce(){
        std::cout << ", I'm Teacher ,"<< "�ҽ̵İ༶�ǣ�" << classes << "\n\n";
    }
protected:
    std::string classes;  //�༶
};
class Student:virtual public Person{
public:
    //����1�����֣�����2:�꼶
    Student(std::string se,unsigned int gra):Person(se){
        grade = gra;
    }
     void introduce(){
         std::cout << ", I'm Student , " << "�����ڵ��꼶�ǣ�" << grade << "��\n\n";
    }
protected:
    unsigned int grade;
};

//ѧ����ʦ�� ��̳�(�ص�) �����̳�˭��ǰ����ִ��˭
class TeacStu:public Teacher,public Student{
public:
    //�ص��ע����̳в����Ĵ��ݺͳ���ִ�е����ȼ���  �ر�ע������Person��Ҫд�ϣ�������̳е�ʱ������ķ��������Ǹ���
    TeacStu(std::string ts1,unsigned int gra,std::string cla):Teacher(ts1,cla),Student(ts1,gra),Person(ts1){
    }
    void introduce(){
        //ע����������Ա�Ǳ����Ĳ�����������
      std::cout << "\n�������ѧУ��ѧ��Ҳ����ʦ,���Ǳ�ҵ��"<< grade<< "�������ڽ�" << classes << "\n";
    }

};

int main(void){
    Teacher tea("��־","����������");
    tea.introduce();
    std::cout << "\n";
    Student stu("�Ż�",2015);
    stu.introduce();
    std::cout << "\n";
    TeacStu ts("������",2014,"C++���ŵ�����");
    ts.introduce();
    return 0;
}
