// char 数据类型 与 字符和字符串参与运算
class Demo_CharString {
    public static void main(String[] args) {
        //1. 字符串参与运算
        System.out.println('a' + 1); // 'a' 转换成ascii码 = 97 + 1 => 98
        System.out.println('a' + 1 + "K-BiuBiu");  //在有字符串参与中被称为字符串连接符  98K-BiuBiu
        System.out.println("5+5="+5+5);   // 5+5=55
        System.out.println("5+5="+(5+5));  //对比上方 5+5=10

        //2. char类型
        char c1 = 97; //取值范围0-65535
        char c2 = 65;
        System.out.println(c1);  //a
        System.out.println(c2);  //A
        //Char类型是可以存储中文，在JAVA中字符都是占用2个字节（中文也是）
        char c3 = '中';
        System.out.println(c3); //中
    }
}