#include <iostream>
#include <string>
#include <vector>
/**��ʾvector����ʹ�õİ���**/

int main(void)
{
    //����һ����������
    std::vector<std::string> names;
    names.push_back("��һ������Ԫ��");
    names.push_back("�ڶ�������Ԫ��");
    names.push_back("����������Ԫ��");

    //������Ԫ�صĸ���
    unsigned int cunt = names.size();
    std::cout <<"������Ԫ�صĸ���: " << cunt << "\n";
    for(int i=0; i < cunt; i++){
        std::cout << names[i] << "\n";
    }
    return 0;
}
