package Day1;

// 循环语句结构
class Demo_Circulation {
    public static void main(String[] args) {
        //1.for 语句
        int sum = 0;
        for(int i = 0; i <= 10; i++)
        {
            if(i % 2 == 0)
            {
                sum += i;
                System.out.print(i+" ");
            }
        }
        System.out.println("\n0~10之间偶数之和："+sum);
        //水仙花数
        for(int i = 100; i <= 999; i++)
        {
            int i1 = i / 100 % 10; //百位
            int i2 = i / 10 % 10;  //十位
            int i3 = i % 10;      //个位
            if(Math.pow(i1, 3) + (Math.pow(i2, 3)) + (Math.pow(i3,3)) == i)
            {
                System.out.println("水仙花数："+i);
            }
        }
        
        //2. while 语句
        int count = 0;  //计数器
        int number = 100;
        while(number <= 999) {
            int ge = number % 10;
            int shi = number / 10 % 10;
            int bai = number / 100 % 10;

            if((Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3)) == number) {
                System.out.print(number+" | ");
                count++;
            }
            number++;
        }
        System.out.println("水仙花数的个数："+count);

        //3. do...while 语句
        int x = 0;
        sum = 0;
        do {
            sum += x;
            x++;
        }while(x <= 100);
        System.out.println("从1+2+..+100 = "+sum);
    }
}
 
//########## 执行结果 ##########
// 0 2 4 6 8 10
// 0~10之间偶数之和：30
// 水仙花数：153
// 水仙花数：370
// 水仙花数：371
// 水仙花数：407
// 153 | 370 | 371 | 407 | 水仙花数的个数：4
// 从1+2+..+100 = 5050