package Day1;

//进制转换案例
class Demo_Scale {
    public static void main(String[] args) {
        //进制输出表示形式
        System.out.println(0b100);   //二进制  4
        System.out.println(0100);    //八进制  64
        System.out.println(100);    //十进制  
        System.out.println(0x100);   //十六进制 256

        //进制转换
        
        //原码/反码/补码
        /* 
        1.已知原码求补码
        * 0b1 011 0100  原码
        * 0b1 100 1011  反码
        * 0b1 100 1100  补码 = 反码 + 1
        2.已知补码求原码
          0b1 110 1110  补码
          0b1 110 1101  反码 = 补码 - 1
          0b1 001 0010  原码  
        */
    }
}