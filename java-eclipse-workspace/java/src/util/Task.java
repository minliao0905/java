package util;


/********* Begin *********/
//����վ̨�࣬ʵ����Ʊ�Ĺ��ܡ�
 public class Task   {	 
	 public static void main(String[] args) {
	        //ʵ����վ̨���󣬲�Ϊÿһ��վ̨ȡ����
	         Station station1=new Station();
	         Station station2=new Station();
	         Station station3=new Station();
	        // ��ÿһ��վ̨������Կ�ʼ����
	         station1.start();
	         station2.start();
	         station3.start();
	}
 }

 class Station extends Thread{
	String name;
	static int tick=20;  //��̬����������
	static Object ob = new Object(); // ����һ����̬Կ�� ֵ�������
	
	 public void ticket() {
	        System.out.println( "�����˵�" + tick + "��Ʊ");
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
                 System.out.println("Ʊ������");
             }
             try {
                 Thread.sleep(100);
             } catch (Exception e) {
             }
	 }
 }
 }

/********* End *********/
