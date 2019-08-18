/**
 * @Filename: ImportJar.java
 * @Author: WeiyiGeek
 * @Function: 导入jar并且使用里面的类和方法
 * @CreateTime: 上午9:13:50
 */

import com.weiyigeek.demo.Demo2;
public class ImportJar {
	public static void main(String[] args) {
		Demo2 i = new Demo2("WeiyiGEEK",15);
		System.out.println("Import Jar！:"+i.getName()+" ,Age:"+i.getAge());
	}
}
