#include <stdio.h>
#include <pthread.h>
#include <time.h>

//建立子线程
void * thread_1(void * parm){
  int i;
  for(i=0;i<3;i++){
    printf("This in the thread processor ：%d\n", i);
    //sleep(1);
  }
  return NULL;
}


//主线程
int main(){
  pthread_t pth1;
  int i , ret;
  ret = pthread_create(&pth1,NULL,thread_1,(void *)(i));   // 加入pthread_join后，主线程"main"会一直等待直到tid这个线程执行完毕自己才结束
  if(ret != 0){
    printf("Create Pthread Failure\n");  //判断是否创建成功,不为0则返回-1 , 注意返回值会影响是否执行子进程
    return -1;
  }
  printf("注释了pthread_join() \t This is start!\n");
  //pthread_join(pth1,NULL);   //  一般项目中需要子线程计算后的值就需要加join方法   // 如果没有join方法可以看看打印的顺序
  printf("加入了getchar() \t This is end!\n");
  getchar();   //当注释_join时加入getchar()进行获取子进程的执行的值
  return 0;
}
