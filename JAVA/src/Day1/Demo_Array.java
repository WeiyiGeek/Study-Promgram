//数组案例
class Demo_Array {
    public static void main(String[] args) {
        //#案例1.1： 动态初始化
        int[] arr = new int[5];  //动态创建5个连续的空间
        System.out.println(arr[0]); //系统默认初始化值，整数类型都是0
        arr[0] = 10;
        arr[1] = 11;
        arr[2] = 12;
        System.out.println(arr[0]); //对数组重新赋值后输出
        /** 
         * 数组arr信息：[I@8102c8
         * [代表是数组，由几个代表几维
         * I代表是int类型
         * @是固定标识位
         * 8102c8代表16进制的地址值
        */
        System.out.println("数组arr信息："+arr);

        //#案例1.2 （3个引用两个数组）
        int[] arr1 = new int[3];
        int[] arr2 = new int[3];
        int[] arr3 = arr2;  // arr3 实际指向arr2的内存地址
        arr1[0] = 1;
        arr2[1] = 2;
        arr3[1] = 3; //arr3将回覆盖arr2[1]的值
        arr3[2] = 3; 
        System.out.println("arr1数组："+arr1[0] + "\t" + arr1[1]  + "\t" + arr1[2]);
        System.out.println("arr2数组："+arr2[0] + "\t" + arr2[1]  + "\t" + arr2[2]);
        System.out.println("arr3数组："+arr3[0] + "\t" + arr3[1]  + "\t" + arr3[2]);
//############ 执行结果 ####################
// 0
// 10
// 数组arr信息：[I@8102c8
// arr1数组：1     0       0
// arr2数组：0     3       3
// arr3数组：0     3       3

        //#案例2.2 静态初始值 (注意不允许动静结合)
        int[] arr4 = new int[] {1,2,3,4,5};  //声明数组引用 (先默认初始化值0 / 然后在显示初始化值)
        int[] arr6;                          //另外一种书写方法
        arr6 = new int[] {5,4,3,2,1};

        int[] arr5 = {1,2,3,4,5};  //简写形式声明和赋值在同一行(必须)
        System.out.println(arr4[0]); //1
        System.out.println(arr5[4]); //5
    }
}