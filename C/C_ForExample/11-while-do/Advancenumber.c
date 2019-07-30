#include <stdio.h>
#include <math.h>

int main()
{
        int ch;
        long long num = 0;
        long long temp; // ��ʱ���������ڲ����Ƿ񳬳���Χ
        int is_overflow = 0;

        const int max_int = pow(2, sizeof(int) * 8) / 2 - 1;
        const int min_int = pow(2, sizeof(int) * 8) / 2 * (-1);
    
        printf("�������ת�����ַ�����");
        do {
                ch = getchar();

                if (ch >= '0' && ch <= '9'){
                        temp = 10 * num + (ch - '0');
                        if (temp > max_int || temp < min_int){
                                is_overflow = 1;
                                break;
                        }
                        else{
                                num = temp;  //��ֵ��������num
                        }
                }
                else{
                        if (num) {
                                break; // ����������֣����˳�ѭ��
                        }
                }
        }
        while (ch != '\n');

        if (is_overflow){
                printf("��ֵ������Χ�����δ���壡\n");
        }
        else
        {
                if (!num){
                        printf("��δ�ҵ��κ���ֵ��\n");
                }
                else{
                        printf("����ǣ�%d\n", num);
                }
        }

        return 0;
}
