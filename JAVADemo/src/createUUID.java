/**
 * # @File : createUUID.java
 * # @CreateTime : 2019/8/9 14:30
 * # @Author : WeiyiGeek
 * # @Function : 生成唯一的UUID
 **/

import java.util.UUID;
public class createUUID {
    public static void main(String[] args) {
        System.out.println(createID());
    }
    public static String createID(){
        UUID uuid = UUID.randomUUID();
        String id=uuid.toString();
        return id.replace("-", "");
    }
}

