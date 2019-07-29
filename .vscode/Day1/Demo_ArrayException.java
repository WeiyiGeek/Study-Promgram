package Day1;

// 数组异常案例
class Demo_ArrayException {
    public static void main(String[] args) {
        //1.数组索引越界异常
        int[] arr = new int[] {0,1,2}; //注意不能动静结合(这里与c/c++中数组是不一样的)
        //发生异常: java.lang.ArrayIndexOutOfBoundsException
        //System.out.println(arr[3]);  //发生异常: java.lang.ArrayIndexOutOfBoundsException

        //2.空指针异常
        int[] arr1 = new int[5];
        arr1 = null; // 使用null进行赋值为空，== 野指针(访问不再是执行堆内存空间的实体)
        //System.out.println(arr1[1]); //发生异常: java.lang.NullPointerException
    }
}