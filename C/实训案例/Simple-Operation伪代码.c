#include <stdio.h>

int qq_process(int taskid,int event)
{
    int taskid_qq = taskid;
    if (event & 1 << 0) {  //ע���·��ֵ
    }else if(event & 1 << 1){
      do some timer
    }
    do something qq
}

int wx_process(int taskid,int event)
{
    do something wx
}

int dota_process(int taskid,int event)
{
    do something dota
}

int av_process(int taskid,int event)
{
    do something av
}

typedef int (*func_process)(int taskid,int event)  // ����ָ��
func_process func[4] = {qq_process,wx_process,dota_process,av_process}
func_process func_init[4] = {qq_init,wx_init,dota_init,av_init}    //��ʼ������=����


//�����ĸ���־λ
int event[4];  //��0���̳�����

void main(void)
{
  int i;

  for (i = 0; i < 4; i++){
      func_init[i](i);   //������ʼ�� 
  }

  while (1)
  {
    for (size_t i = 0; i < 4; i++)
    {
        if (event[i])  //�����¼����������
        {
          func[i](i,event[i]); //���ں������루������̺ţ��¼�������
        }
    }
  }


}


___interrupt key_fun()  //�����¼�
{
  event[0] = 1 | 1 << 0;    //��λ
}

___interrupt timer()
{
  event[0] = 1 | 1 << 1;
}
