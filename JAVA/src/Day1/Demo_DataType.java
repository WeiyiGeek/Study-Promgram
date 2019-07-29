//数据类型与变量 案例
class Demo_DataType {
    public static void main(String[] args) {
        //整数类型
        byte b = 10;   //1Byte
        short s = 20;  //2Byte
        int  i = 30;   //4Byte
        long x = 40;   //8Byte 有时候还需要加入一个L字符表示long类型
        long x1 = 888888888888L; //在long类型后也可使用l但是不建议使用小写的l  (注意点)

        //浮点数
        float f = 12.36F;  //4Byte 如果是小数要为float类型需要在小数后加F (主要点)
        double d = 33.67;  //8Byte 小数默认的数据类型是Double; 也可以加上d/D 表示()

        //字符类型
        char c = 'a';   //2Byte (注意java字符类型占用两个字节)
        System.out.println(c);

        //布尔类型
        boolean b1 = true;  //没有明确得规定占用几个字节 （注意点）
        boolean b2 = false;
        System.out.println(b1);

        //变量问题 
        //1.使用前必须赋值
        int x2,y,z;
        x2 = 1;
        y = 2;
        z = 3;
        System.out.println(x2); //1
    }
}