#include "head.h"
//分别实现类里面的one方法
const unsigned short ONE = 1024;

//one中函数声明
int first(int o);

#if 0
//在预编译段不解析该段代码
void Def::oneFun(); //类里面的函数声明不需要写在头文件中会导致错误
#endif
