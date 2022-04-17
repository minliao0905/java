package Thread;

public class Chihuo extends Thread{
private Baozi bz;
public Chihuo(Baozi bz) {
	this.bz = bz;
}
	@Override
public void run() {
		while(true) {
			  synchronized(bz) {
				  if(bz.flag==false) {
					  try {
						  //等待状态
						  bz.wait();
					  }catch(InterruptedException e) {
						  e.printStackTrace();
					  }
				  }
				  //唤醒
				  System.out.println("吃货正在吃"+bz.pi+bz.xian+"包子");
				  bz.flag = false;
				  bz.notify();
				  System.out.println(bz.pi+bz.xian+"包子"+"已经吃完了");
				  System.out.println("----------------------");
				  		 
		}
	  }
}
	
	
}
