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
						  //�ȴ�״̬
						  bz.wait();
					  }catch(InterruptedException e) {
						  e.printStackTrace();
					  }
				  }
				  //����
				  System.out.println("�Ի����ڳ�"+bz.pi+bz.xian+"����");
				  bz.flag = false;
				  bz.notify();
				  System.out.println(bz.pi+bz.xian+"����"+"�Ѿ�������");
				  System.out.println("----------------------");
				  		 
		}
	  }
}
	
	
}
