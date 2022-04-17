package Thread;
//创建多线程程序的第二种 runnable
public class Demo03Runnable {
   public static void main(String[] args) {
	   RunnableImpl run = new RunnableImpl();
	   Thread  t = new Thread(run);
	 // 调用Thread类的start 方法 ，开启新线程执行run方法
	   t.start();
	   Thread t2 = new Thread(new RunnableImpl());
	   t2.start();
	   
//	   for(int i=0;i<20;i++) {
//	    	System.out.println(Thread.currentThread().getName()+"-->"+i);
//	    }
   }
}
