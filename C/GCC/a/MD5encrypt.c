#include <stdio.h>
#include <string.h>
#include "md5.h"

int main(void)
{
        int i;
        unsigned char encrypt[] = "FishC";
        unsigned char decrypt[16];

        MD5_CTX md5;
        // ��ʼ��
        MD5Init(&md5);
        // ���������ַ������䳤��
        MD5Update(&md5, encrypt, strlen((char *)encrypt));
        // �õ����ܺ���ַ���
        MD5Final(&md5, decrypt);

        for (i = 0; i < 16; i++)
        {
                printf("%02x", decrypt[i]); //2λ16���Ʋ�����0��λ
        }
        putchar('\n');

        return 0;
}
