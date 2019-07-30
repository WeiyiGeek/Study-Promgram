#include <stdio.h>

int qq_process(int taskid,int event)
{
    int taskid_qq = taskid;
    if (event & 1 << 0) {  //注意短路求值
    }else if(event & 1 << 1){
      do some timer
    }
    do something qq
}

int wx_process(int taskid,int event)
{
    do something wx
}

int dota_process(int taskid,int event)
{
    do something dota
}

int av_process(int taskid,int event)
{
    do something av
}

typedef int (*func_process)(int taskid,int event)  // 函数指针
func_process func[4] = {qq_process,wx_process,dota_process,av_process}
func_process func_init[4] = {qq_init,wx_init,dota_init,av_init}    //初始化函数=进程


//建立四个标志位
int event[4];  //非0进程程序工作

void main(void)
{
  int i;

  for (i = 0; i < 4; i++){
      func_init[i](i);   //开机初始化 
  }

  while (1)
  {
    for (size_t i = 0; i < 4; i++)
    {
        if (event[i])  //基于事件的任务调度
        {
          func[i](i,event[i]); //对于函数传入（任务进程号，事件）参数
        }
    }
  }


}


___interrupt key_fun()  //按键事件
{
  event[0] = 1 | 1 << 0;    //置位
}

___interrupt timer()
{
  event[0] = 1 | 1 << 1;
}
