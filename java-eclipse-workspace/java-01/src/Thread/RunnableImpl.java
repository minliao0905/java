package Thread;
//Runnable ��ʵ����
//Runnable��һ���ӿ� �������߳�����Ϳ������߳̽��з��루������
public class RunnableImpl implements Runnable {
	@Override
	public void run() {
		 for(int i=0;i<20;i++) {
		    	System.out.println("hello"+"-->"+i);
		    }
	}
	

}
