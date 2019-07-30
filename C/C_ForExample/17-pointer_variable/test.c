#include <stdio.h>

#define NUM 5

int main()
{
        char slogans[NUM][100] = {
                "I love FishC.com!",
                "Keep moving!",
                "Impossible is nothing!",
                "Just do it!",
                "I am what I am!"};
        int i;

        for (i = 0; i < NUM; i++)
        {
                printf("%s\n", slogans[i][1]);
        }

        return 0;
}

