/**
 * 数组工具类验证(注意生成doc文档的java类需要设置public关键字)
 * @author Weiyigeek
 * @version v1.0
 * **/
public class ArrayTools {
    //私有构造方法
    private ArrayTools() {}
    /**
     * getArrMax获取数组中最大值
     * @param arr 接收一个int类型的数据在
     * @return 返回数据在中的最大值
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