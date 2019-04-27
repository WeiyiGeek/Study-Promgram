// 匿名对象案例
class Demo_AnonymousObject {
	public static void main(String[] args) {
		//1.对比有名字对象与匿名对象的区别
		/*Car c1 = new Car();			//创建有名字的对象
		c1.run();
		c1.run();

		new Car().run();			//匿名对象调用方法
		new Car().run();	*/		//匿名对象只适合对方法的一次调用,因为调用多次就会产生多个对象,不如用有名字的对象	
	
	
		//2.查看下面匿名对象的内存图
		new Cars().color="red";
		new Cars().num=8;
		new Cars().run();

		//3.匿名对象可以作为参数传递
		method(new Cars());  //创建匿名对象，并将该对象的地址传递个method中Car c对象
		method(new Cars());
	}

	/** 抽取方法提高代码的复用性 */
	public static void method(Cars c)
	{
		c.color="red";
		c.num=1024;
		c.run();
	}
}

class Cars {
    int num;        //轮胎数
	String color;	//颜色
	public void run() {
		System.out.println(color + ".|." + num);
	}
}