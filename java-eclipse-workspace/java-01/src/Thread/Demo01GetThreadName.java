package Thread;

public class Demo01GetThreadName {

	public static void main(String[] args) {
		//创建Thread类的子类对象
		Mythread01 mt = new Mythread01();
		mt.start();
		mt.setName("名字");
		
		new Mythread01().start();
		new Mythread01().start();
		//开启多线程
		new  Mythread01("xiaoqiang").start();

	}

}
