package Thread;
//设置线程的名称
/*
 * 1使用Thread类的方法setName(名字）;    void  setName(String name)改变线程名称 使之与参数name相同
 * 2.创建一个带参数的构造方法
 * 
 */
public class Mythread01 extends Thread{
@Override
	public void run() {
		//获取线程名称
	//String name = getName();
	//System.out.println(name);
	Thread t = Thread.currentThread();
	System.out.println(t);
    
	String name = t.getName();
	System.out.println(name);
	
	
//链式写法	System.out.println(Thread.currentThread().getName());
	
	}

//让父类给起名
public Mythread01() {}
public   Mythread01(String name) {
	super(name);
}
}
