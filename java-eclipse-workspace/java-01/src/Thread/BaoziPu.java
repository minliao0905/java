package Thread;

public class BaoziPu extends Thread{
	//��Ա�������ӱ���
  private Baozi bz;
  //ʹ�ô��������췽������ֵ
  public BaoziPu(Baozi bz) {
	  this.bz= bz;
  }
  //�߳����� run �������� ��дrun����;
  @Override
  public void run() {
	  int count = 0;
	  while(true) {//ѭ��������
	  //��֤���߳�ֻ��һ����ִ��
	  synchronized(bz) {
		  if(bz.flag==true) {
			  try {
				  //�ȴ�״̬
				  bz.wait();
			  }catch(InterruptedException e) {
				  e.printStackTrace();
			  }
		  }
		  
		  if(count%2==0) {
			  bz.pi="��Ƥ";
			  bz.xian = "����";
		  } else {
			  bz.pi="��Ƥ";
			  bz.xian="ţ����";
			  
			  }
		  count++;
		  System.out.println("����������������"+bz.pi+bz.xian+"����");
		  try {
			  Thread.sleep(3000);
			  
		  }catch(InterruptedException e){
			  e.printStackTrace();
		  }
		  //������������
		  bz.flag= true;
		  //�����߳�
		  bz.notify();
		  System.out.println("�������Ѿ�������"+bz.pi+bz.xian+"����");
	  }
   }
	  
  }
  
}
