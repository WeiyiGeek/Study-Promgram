#include <stdio.h>
int main()
{
        float fah, cel;

        printf("���������϶ȣ�");
        scanf("%f", &cel);
       // fah = 9 / 5 * cel + 32; //(fah-32) * 5 /9 ���Ǵ���� �������ȼ���ͬ
        fah = cel * 9 / 5 + 32;  //������ȷ�������¶ȼ��㻪���¶�
        printf("ת��Ϊ������ǣ�%.2f\n", fah);
        return 0;
}
