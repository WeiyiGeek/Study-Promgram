#include <iostream>
#include <string>
/**
验证虚继承类
virtual
**/
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

//继承Person类 注意这里是虚继承
class Teacher:virtual public Person{
public:
    //子类构造器 参数1：名字，参数2:所交班级
    Teacher(std::string te,std::string cla):Person(te){
        classes = cla;
    }
    void introduce(){
        std::cout << ", I'm Teacher ,"<< "我教的班级是：" << classes << "\n\n";
    }
protected:
    std::string classes;  //班级
};
class Student:virtual public Person{
public:
    //参数1：名字，参数2:年级
    Student(std::string se,unsigned int gra):Person(se){
        grade = gra;
    }
     void introduce(){
         std::cout << ", I'm Student , " << "我所在的年级是：" << grade << "级\n\n";
    }
protected:
    unsigned int grade;
};

//学生老师类 多继承(重点) 这里多继承谁在前就先执行谁
class TeacStu:public Teacher,public Student{
public:
    //重点关注（多继承参数的传递和程序执行的优先级）  特别注意这里Person类要写上，采用虚继承的时候，子类的方法将覆盖父类
    TeacStu(std::string ts1,unsigned int gra,std::string cla):Teacher(ts1,cla),Student(ts1,gra),Person(ts1){
    }
    void introduce(){
        //注意这里的类成员是保护的才能这样引用
      std::cout << "\n我是这个学校的学生也是老师,我是毕业于"<< grade<< "级，现在教" << classes << "\n";
    }

};

int main(void){
    Teacher tea("李志","物联网工程");
    tea.introduce();
    std::cout << "\n";
    Student stu("张辉",2015);
    stu.introduce();
    std::cout << "\n";
    TeacStu ts("张扎哈",2014,"C++入门到放弃");
    ts.introduce();
    return 0;
}
