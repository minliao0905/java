package Thread_safe;
class Mythread implements Runnable{

	@Override
	public void run() {
		for(int i=0;i<6;i++) {
			System.out.println(Thread.currentThread().getName()+i);
			
		}
		
	}
	
}
public class Demo01 {

	public static void main(String[] args) throws InterruptedException {
        //�����߳�
		Thread thread1 = new Thread(new Mythread(),"thread1");
		thread1.start();
		for(int i=0;i<6;i++) {
			System.out.println(Thread.currentThread().getName()+i);
			if(i==2) {
				thread1.join();     //����join��������Ӵ���,�������join���������
			}
		}
	}

}
