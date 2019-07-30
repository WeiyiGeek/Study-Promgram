#include <stdio.h>
#include <string.h>
#include "md5.h"

int main(void)
{
        int i;
        unsigned char encrypt[] = "FishC";
        unsigned char decrypt[16];

        MD5_CTX md5;
        // 初始化
        MD5Init(&md5);
        // 传入明文字符串及其长度
        MD5Update(&md5, encrypt, strlen((char *)encrypt));
        // 得到加密后的字符串
        MD5Final(&md5, decrypt);

        for (i = 0; i < 16; i++)
        {
                printf("%02x", decrypt[i]); //2位16进制不足以0补位
        }
        putchar('\n');

        return 0;
}
