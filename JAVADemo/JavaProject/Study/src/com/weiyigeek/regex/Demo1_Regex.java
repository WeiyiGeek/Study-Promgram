/**
 *  * a:非正则表达式实现 
    * b:正则表达式实现
	*    需求: 校验qq号码
    * 1:要求必须是5-15位数字
    * 2:0不能开头
    * 3:必须都是数字
 */

package com.weiyigeek.regex;
public class Demo1_Regex {
	public static void main(String[] args) {
		//示例1.采用非正则表达式实现 param1 String
		String str = new String("12345678");
		System.out.println("非正则验证匹配 :  "+notRegex(str));
		
		//示例2：正则方式String.matches()
		System.out.println("正则匹配结果 : " + str.matches("^[1-9]\\d{4,14}"));
		System.out.println("正则匹配结果 : " + "01234579".matches("^[1-9]\\d{4,14}"));
	}

	private static boolean notRegex(String str) {
		boolean flag = false;
		if(str.length() > 4 && str.length() < 16){
			if(!str.startsWith("0")) {
				char[] arr = str.toCharArray();
				for (int i = 0; i < arr.length; i++) {
					if(arr[i] > '0' && arr[i] < '9') {
						flag = true;
					}else {
						break;
					}
				}
			}
		}
		return flag;
	}
}
