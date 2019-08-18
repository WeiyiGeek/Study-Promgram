
public class Demo2 {

	public static void main(String[] args) {
		//示例1：hashCode() 的使用
		Object obj1 = new Object();
		System.out.println("Object 对象："+obj1.hashCode());
		System.out.println("Object 对象地址："+System.identityHashCode(obj1));
	
		//示例2.getclass() 的使用
		Person g = new Person(1,"WeiyiGeek");
		Class demo = g.getClass(); //获取对象的字节码文件
		System.out.println("Person 类名称:"+demo.getName()); //获取类名称

		//示例3.toString() 的使用
		String info = g.toString();
		System.out.println(info);
		System.out.println(g); //如果直接答应对象的引用，会默认调用toString方法
		
		
		//示例4.equals() 的使用
		//Object中的equals方法比较对象的地址值,没有什么意义，我们需要重写他；
		//因为在开发中我们通常比较对象中的属性值,我们认为相同属性是同一对象,这样我们就需要重写他;
		Person g1= new Person(1,"WeiyiGeek");
		System.out.println(g1.equals(g));  //实际还是采用下面==方式比较,但我们对方法进行了重写
		System.out.println(g1 == g );  //如果equals
	}

}

class Person {
	public String name;
	public int num = 1;
	public Person() {
		super();
	}
	public Person(int num,String name) {
		this.num = num;
		this.name = name;
	}
	//关键点1
	@Override
	public String toString() {
		System.out.println("重写toString方法：num = "+num);
		return super.toString();
	}
	//关键点2 : 重写object中的equals方法
	@Override
	public boolean equals(Object obj) {
		//向下转型
		Person s = (Person)obj;
		return this.name.equals(s.name) && this.num == s.num;
	}
	

}
