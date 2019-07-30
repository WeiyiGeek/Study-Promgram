#include <iostream>
#include <string>
/** 验证多继承类  **/

class Person{
public:
    //子类构造器
    Person(std::string pname){
        name = pname;
        std::cout << "My Name is：" << name;
    }
protected:
    std::string name;
};

//继承Person类
class Teacher:public Person{
public:
    //子类构造器 参数1：名字，参数2:所交班级
    Teacher(std::string te,std::string cla):Person(te){
        classes = cla;
        std::cout << ", I'm Teacher，Class(班级) "<< classes <<"\n";
    }
    void bj(){
        std::cout << "我教的班级是：" << classes << "\n\n";
    }
protected:
    std::string classes;  //班级
};
class Student:public Person{
public:
    //参数1：名字，参数2:年级
    Student(std::string se,unsigned int gra):Person(se){
        grade = gra;
        std::cout << ", I'm Student , Grade(年级) " << grade <<" \n";
    }
     void nj(){
        std::cout << "我所在的年级是：" << grade << "级\n\n";
    }

protected:
    unsigned int grade;
};

//学生老师类 多继承(重点) 这里多继承谁在前就先执行谁
class TeacStu:public Teacher,public Student{
public:
    //重点关注（多继承参数的传递和程序执行的优先级）
    TeacStu(std::string ts1,unsigned int gra,std::string cla):Teacher(ts1,cla),Student(ts1,gra){
    }
    void introduce(){
        //注意这里的类成员是保护的才能这样引用
      std::cout << "我是" << Student::name << "这个学校的学生也是老师,我是毕业于"<< Student::grade<< "级，现在教" << Teacher::classes << "\n";
    }
};

int main(void){
    Teacher tea("李志","物联网工程");
    tea.bj();
    std::cout << "\n";
    Student stu("张辉",2015);
    stu.nj();
    std::cout << "\n";
    TeacStu ts("张扎哈",2014,"C++入门到放弃");
    ts.introduce();
    return 0;
}
