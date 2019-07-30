#include <stdio.h>
#include <sys/time.h>


int main(){
	struct timeval tvv;
        struct timezone tzv;
        gettimeofday(&tvv,&tzv);

    printf("√Î ˝tv_sec:%d\n",tvv.tv_sec);
    printf("Œ¢√Îtv_usec:%d\n",tvv.tv_usec);

    printf(" ±≤Ótz_minuteswest:%d\n",tzv.tz_minuteswest);
    printf("tz_dsttime:%d\n",tzv.tz_dsttime);
}

