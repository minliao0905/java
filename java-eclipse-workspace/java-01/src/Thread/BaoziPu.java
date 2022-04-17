package Thread;

public class BaoziPu extends Thread{
	//成员创建包子变量
  private Baozi bz;
  //使用带参数构造方法，赋值
  public BaoziPu(Baozi bz) {
	  this.bz= bz;
  }
  //线程任务 run 生产包子 重写run方法;
  @Override
  public void run() {
	  int count = 0;
	  while(true) {//循环生产；
	  //保证两线程只有一个在执行
	  synchronized(bz) {
		  if(bz.flag==true) {
			  try {
				  //等待状态
				  bz.wait();
			  }catch(InterruptedException e) {
				  e.printStackTrace();
			  }
		  }
		  
		  if(count%2==0) {
			  bz.pi="薄皮";
			  bz.xian = "三鲜";
		  } else {
			  bz.pi="冰皮";
			  bz.xian="牛肉大葱";
			  
			  }
		  count++;
		  System.out.println("包子铺正在生产："+bz.pi+bz.xian+"包子");
		  try {
			  Thread.sleep(3000);
			  
		  }catch(InterruptedException e){
			  e.printStackTrace();
		  }
		  //包子生产好了
		  bz.flag= true;
		  //唤醒线程
		  bz.notify();
		  System.out.println("包子铺已经生产："+bz.pi+bz.xian+"包子");
	  }
   }
	  
  }
  
}
