#include <stdio.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>

/*子线程1执行的函数*/
void * thread_1(void * str)
{
  int i;
  for (i = 0; i < 6; ++i) {
    sleep(10);
    printf("This in the thread_1 : %d\n",i );

  }
}


int main()
{
  pthread_t pth1;
  int i,ret;
  ret = pthread_create(&pth1,NULL,thread_1,(void *)(i));  //创建线程
  if(ret != 0){
    printf("Create pthread Failure!\n");
    return -1;
  }

  printf("----------------------程序开始-------------------------\n");
  for(i = 0; i < 6; ++i){
    sleep(1);
    printf("This in the Main Processor ： %d\n",i);

  }

  pthread_join(pth1,NULL);  /*等待线程1结束*/
  printf("----------------------程序结束-------------------------\n");
  return 0;
}
