package com.weiyi.Test;

import java.util.Date;
import org.junit.Test;

/**
 * 使用junit进行单元测试
 * @author WeiyiGeek
 */
public class MainTest {
	
	//单元测试需要测试的方法
	@Test
	public void testPrint() {
		Date date = new Date();
		System.out.println("当前时间:" + date.toGMTString());
	}
}
