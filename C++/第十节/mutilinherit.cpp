#include <iostream>
#include <string>
/** ��֤��̳���  **/

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

//�̳�Person��
class Teacher:public Person{
public:
    //���๹���� ����1�����֣�����2:�����༶
    Teacher(std::string te,std::string cla):Person(te){
        classes = cla;
        std::cout << ", I'm Teacher��Class(�༶) "<< classes <<"\n";
    }
    void bj(){
        std::cout << "�ҽ̵İ༶�ǣ�" << classes << "\n\n";
    }
protected:
    std::string classes;  //�༶
};
class Student:public Person{
public:
    //����1�����֣�����2:�꼶
    Student(std::string se,unsigned int gra):Person(se){
        grade = gra;
        std::cout << ", I'm Student , Grade(�꼶) " << grade <<" \n";
    }
     void nj(){
        std::cout << "�����ڵ��꼶�ǣ�" << grade << "��\n\n";
    }

protected:
    unsigned int grade;
};

//ѧ����ʦ�� ��̳�(�ص�) �����̳�˭��ǰ����ִ��˭
class TeacStu:public Teacher,public Student{
public:
    //�ص��ע����̳в����Ĵ��ݺͳ���ִ�е����ȼ���
    TeacStu(std::string ts1,unsigned int gra,std::string cla):Teacher(ts1,cla),Student(ts1,gra){
    }
    void introduce(){
        //ע����������Ա�Ǳ����Ĳ�����������
      std::cout << "����" << Student::name << "���ѧУ��ѧ��Ҳ����ʦ,���Ǳ�ҵ��"<< Student::grade<< "�������ڽ�" << Teacher::classes << "\n";
    }
};

int main(void){
    Teacher tea("��־","����������");
    tea.bj();
    std::cout << "\n";
    Student stu("�Ż�",2015);
    stu.nj();
    std::cout << "\n";
    TeacStu ts("������",2014,"C++���ŵ�����");
    ts.introduce();
    return 0;
}
