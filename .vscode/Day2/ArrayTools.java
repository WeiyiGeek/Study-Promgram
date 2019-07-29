package Day2;

/**
 * ���鹤������֤(ע������doc�ĵ���java����Ҫ����public�ؼ���)
 * @author Weiyigeek
 * @version v1.0
 * **/
public class ArrayTools {
    //˽�й��췽��
    private ArrayTools() {}
    /**
     * getArrMax��ȡ���������ֵ
     * @param arr ����һ��int���͵�������
     * @return �����������е����ֵ
     ***/
    public static int getArrMax(int[] arr)
    {
       int max = arr[0];
       for(int i = 0; i < arr.length; i++)
       {
           max = max > arr[i] ? max:arr[i];
       } 
       return max;
    }
}