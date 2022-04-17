package Text01;

public class GuardeObject {
   private  int id;          //GuardeObject的标识id
   
   public GuardeObject(int id) {
	 this.id = id;  
   }
   public int getId() {
	   return id;
   }
   //结果
   private Object response;
   
   
   //获取结果//若没有结果则等待
   public  Object get(long timeout) {
	   synchronized(this) {
		   //timeout 表示要等待多久；
		   long begin = System.currentTimeMillis(); 
		    //开始时间；
		   long passedtime = 0;
		   while(response == null) {
			   long waitTime = timeout - passedtime;   //循环应该等待时间；
			   if(waitTime <=0) {
				   break;    //超出时间则跳出循环
			   }
			   try {
				   this.wait(waitTime);    
				   //防止虚假唤醒  ，线程可能被其他唤醒，导致未到两秒时间就被唤醒，所以置为waitTime ,而不是timeout
			   }catch(InterruptedException e) {
				   e.printStackTrace();
			   }
			 passedtime = System.currentTimeMillis()- begin;
		   } 
		   return  response;
	   }
	  
   }
   
   //产生结果；
   public  void complete(Object response) {
	   //给结果成员变量赋值
	   synchronized(this) {
		   this.response = response;
		   this.notifyAll();
	   }
   }

}
