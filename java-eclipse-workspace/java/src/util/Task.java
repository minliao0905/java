package util;


/********* Begin *********/
//定义站台类，实现卖票的功能。
 public class Task   {	 
	 public static void main(String[] args) {
	        //实例化站台对象，并为每一个站台取名字
	         Station station1=new Station();
	         Station station2=new Station();
	         Station station3=new Station();
	        // 让每一个站台对象各自开始工作
	         station1.start();
	         station2.start();
	         station3.start();
	}
 }

 class Station extends Thread{
	String name;
	static int tick=20;  //静态变量！！！
	static Object ob = new Object(); // 创建一个静态钥匙 值是任意的
	
	 public void ticket() {
	        System.out.println( "卖出了第" + tick + "张票");
	        tick--;
	    }
	 
	public  void run() {
		
         while(tick>0) {
        	 synchronized (ob) {
                 if (tick > 0) {
                	 ticket();
                 } 
             }
             if(tick == 0){
                 System.out.println("票卖完了");
             }
             try {
                 Thread.sleep(100);
             } catch (Exception e) {
             }
	 }
 }
 }

/********* End *********/
