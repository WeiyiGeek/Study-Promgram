#include "head.h"
//命名空间为demo
namespace demo{
    Base::Base(){
        std::cout << "构造器-INIT\n";
    }
   Base::~Base(){
        std::cout << "析构器-INIT\n";
    }
    void Base::print(){
        std::cout << "---- I love Study C++ plus Pragram！----\n";
    }
}
//#注意无;号
