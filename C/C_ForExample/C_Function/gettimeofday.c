#include <stdio.h>
#include <sys/time.h>


int main(){
	struct timeval tvv;
        struct timezone tzv;
        gettimeofday(&tvv,&tzv);

    printf("����tv_sec:%d\n",tvv.tv_sec);
    printf("΢��tv_usec:%d\n",tvv.tv_usec);

    printf("ʱ��tz_minuteswest:%d\n",tzv.tz_minuteswest);
    printf("tz_dsttime:%d\n",tzv.tz_dsttime);
}

