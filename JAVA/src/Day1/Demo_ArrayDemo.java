//一维/多维数组
class Demo_ArrayDemo {
    public static void main(String[] args) {
        //案例1：常规数组遍历
        int[] arr = {126,115,17,129,80};
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+"\t");
        }
        System.out.println();

        //案例2: 封装方法调用数组遍历
        print(arr);
        //案例3：获取数组中的最大值
        System.out.println("\n数组arr最大值："+printMax(arr));
        //案例4：反转数组
        reverseArray(arr);
        //案例5：查找数组元素(返回其索引)
        int res = searchIndex(115, arr);
        if(res != -1)
        {
            System.out.println("\n查询值得Index = " + res);
        }else{
            System.out.println("\n未查询到相应值的索引！");
        }
    }

    /***
     * function_name: print
     * function：数组的遍历
     * param：参数列表int[] arr
     * return：返回值类型void
     */
    public static void print(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+"\t");
        }
    }

    /**
     * function_name：printMax
     * function:获取数组中最大值
     * 参数：int[] arr
     * 返回：int 类型
     */
    public static int printMax(int[] arr1) {
        int max = arr1[0];  //这里记录数组中第一值就行
        for(int i = 1; i < arr1.length; i++)
        {
            max = max > arr1[i] ? max:arr1[i];
        }
        return max;
    }

    /**
     * function_name : reverseArray 
     * function：数组元素反转
     * 参数：传入数组
     * 返回值：void
     **/
    public static void reverseArray(int[] arr2) {
        for(int i = 0 ; i < arr2.length / 2 ; i++)
        {
            int temp = arr2[i];
            arr2[i] = arr2[arr2.length-1-i]; //注意这里需要进行-1
            arr2[arr2.length-1-i] = temp;
        }
        //之后再调用上面的输出即可
        print(arr2);
    }

    /**
     * function_name: searchIndex
     * function:查找对应元素的索引
     * 参数：传入查找的int值，与int[] arr数组
     * 返回值：int类型的索引值
     */
    public static int searchIndex(int value,int[] arr3)
    {   
        int index = -1;
        for(int i = 0; i < arr3.length; i++)
        {
            if(arr3[i] == value)
            {
                return i;
            }
        }
        return index; 
    }
}

//############## 执行结果 ############
// 126     115     17      129     80
// 126     115     17      129     80
// 数组arr最大值：129
// 80      129     17      115     126
// 查询值得Index = 3