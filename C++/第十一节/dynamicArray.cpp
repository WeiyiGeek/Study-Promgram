#include <iostream>
/**��̬���鰸��**/

int main(void){

    unsigned int num;
    std::cout << "������һ�������涨������ĳ��ȣ�";
    std::cin  >> num;

    //�����ڴ�ռ�
    int *px = new int[num];
    //�����ʹ����ʽ
    for(int i=0; i < num; i++){
        px[i] = i;
    }

    for(int i = num - 1; i >= 0; i--){
        //ָ���ʹ����ʽ
        std::cout << "px[" << i << "]��ֵΪ��" << *(px+i) << std::endl;
        std::cout << "px[" << i << "]��ֵΪ��" << (*px+i) << std::endl;
    }
    //������ɾ��
    delete []px;
    std::cout << "END";
    return 0;
}
