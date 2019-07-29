package Day1;

//*多维数组 *//
class Demo_MutilArray {
    public static void main(String[] args) {
        //1. 方式1
        int[][] arr = new int[2][3];  // 默认初始化值为0 (注意与下面方式4得异同)
        //2. 方式2
        int[] arr1[] = new int[2][3];
        //3. 方式3
        int arr2[][] = new int[2][3];

        System.out.println("方式1："+arr[0]+" ,首地址："+ arr); //打印得是一维arr[0]得地址与arr[0][0]首地址 【注意这里与C语言不同】
        System.out.println("方式2："+arr1[0][0]);
        System.out.println("方式3："+arr2[1][2]); // 2行/三列

        //4. 方式4
        int[][] arr3 = new int[3][]; //存放了三个一维数组  默认初始化值为null，由于我们没有给出二维数组得值；
        System.out.println(arr3[0] +", " +arr3[1] +", "+arr3[2]);
        arr3[0] = new int[3]; //第一个一维数组存放了3个int值
        arr3[1] = new int[5]; //第二个一维数组存放了5个int值
        System.out.println(arr3[0] +", " +arr3[1] +", "+arr3[2]);


//############### 执行结果 ###############        
// 方式1：[I@df1c96 ,首地址：[[I@8102c8
// 方式2：0
// 方式3：0
// null, null, null
// [I@163006a, [I@1be847c, null

        
        //**案例1 */
        int[][] arr4 = {{1,2,3},{4,5},{6,7,8,9}};
        System.out.println("arr4:"+arr4+", arr[0]:"+ arr[0] + ", arr[0][0]:" + arr[0][0]+"\n");
        //arr4 : 是一个二维数组地址值
        //arr4[0] : 一维数组得地址值
        //arr4[0][0] : 二维数组中得元素值
        //外循环控制行，内循环控制列
        for(int i = 0; i < arr4.length; i++ )
        {
            for(int j = 0; j < arr4[i].length; j++)  //获取每一一个一维数组中得元素
            {
                System.out.print(arr4[i][j] + "\t");
            }
            System.out.println("\n");            
        }

        //**案例2：将数组进行参数传递后值将被改变 */
        int[] arr5[] = {{1,2},{3,4,7}};
        arrayChange(arr5);  //数组中得值将发生改变
        for(int i = 0; i < arr5.length; i++ )
        {
            for(int j = 0; j < arr5[i].length; j++)  //获取每一一个一维数组中得元素
            {
                System.out.print(arr5[i][j] + "\t");
            }
            System.out.println();            
        }
    } 

    /**
     * 函数名：arrayChange
     * 函数功能：实现二维数组中值进行*+1
     * 函数参数：array[][] 二维数组
     * 函数返回值：none
     */
     public static void arrayChange(int[][] array){
        for(int i = 0; i < array.length; i++ )
        {
            for(int j = 0; j < array[i].length; j++)  //获取每一一个一维数组中得元素
            {
                array[i][j] += 1;
            }
        }
     }

}

// ############### 执行结果  ##############
// arr4:[[I@1975e01, arr[0]:[I@df1c96, arr[0][0]:0
// 1       2       3
// 4       5
// 6       7       8       9

// 2       3
// 4       5       8