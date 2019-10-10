
public class Demo_Classdesign {
	public static void main(String[] args) {
		// 装饰设计模式
		// 优点:耦合性没有这么强,便于功能的扩展;（值得学习借鉴）
		Tea t = new Tea(new Stu());
		t.able();
	}
}

//接口
interface code{
	public void able();
}

//扩展接口
class Stu implements code {
	@Override
	public void able() {
		// TODO Auto-generated method stub
		System.out.println("C");
		System.out.println("C++");
		System.out.println("VF");
	}
}

//装饰设计(精华之处)
class Tea implements code {
	private Stu demo;  //获取到被包装的类的引用
	public Tea(Stu demo) { //通过构造函数创建对象的时候,传入被包装的对象
		super();
		this.demo = demo;
	}

	@Override
	public void able() {
		// TODO Auto-generated method stub
		demo.able();  //扩展技能
		System.out.println("### 扩展的技能 ###");
		System.out.println("Python");
		System.out.println("Perl");
		System.out.println("php");
		System.out.println("Javascript");
		System.out.println("Java");
		System.out.println("Node.js");
		System.out.println("HTML/XML");
	}
}