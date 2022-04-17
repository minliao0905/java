package Thread;
//Runnable 的实现类
//Runnable是一个接口 把设置线程任务和开启新线程进行分离（解锁）
public class RunnableImpl implements Runnable {
	@Override
	public void run() {
		 for(int i=0;i<20;i++) {
		    	System.out.println("hello"+"-->"+i);
		    }
	}
	

}
