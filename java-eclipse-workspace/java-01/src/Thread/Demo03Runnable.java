package Thread;
//�������̳߳���ĵڶ��� runnable
public class Demo03Runnable {
   public static void main(String[] args) {
	   RunnableImpl run = new RunnableImpl();
	   Thread  t = new Thread(run);
	 // ����Thread���start ���� ���������߳�ִ��run����
	   t.start();
	   Thread t2 = new Thread(new RunnableImpl());
	   t2.start();
	   
//	   for(int i=0;i<20;i++) {
//	    	System.out.println(Thread.currentThread().getName()+"-->"+i);
//	    }
   }
}
