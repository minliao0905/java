package Text01;

public class GuardeObject {
   private  int id;          //GuardeObject�ı�ʶid
   
   public GuardeObject(int id) {
	 this.id = id;  
   }
   public int getId() {
	   return id;
   }
   //���
   private Object response;
   
   
   //��ȡ���//��û�н����ȴ�
   public  Object get(long timeout) {
	   synchronized(this) {
		   //timeout ��ʾҪ�ȴ���ã�
		   long begin = System.currentTimeMillis(); 
		    //��ʼʱ�䣻
		   long passedtime = 0;
		   while(response == null) {
			   long waitTime = timeout - passedtime;   //ѭ��Ӧ�õȴ�ʱ�䣻
			   if(waitTime <=0) {
				   break;    //����ʱ��������ѭ��
			   }
			   try {
				   this.wait(waitTime);    
				   //��ֹ��ٻ���  ���߳̿��ܱ��������ѣ�����δ������ʱ��ͱ����ѣ�������ΪwaitTime ,������timeout
			   }catch(InterruptedException e) {
				   e.printStackTrace();
			   }
			 passedtime = System.currentTimeMillis()- begin;
		   } 
		   return  response;
	   }
	  
   }
   
   //���������
   public  void complete(Object response) {
	   //�������Ա������ֵ
	   synchronized(this) {
		   this.response = response;
		   this.notifyAll();
	   }
   }

}
