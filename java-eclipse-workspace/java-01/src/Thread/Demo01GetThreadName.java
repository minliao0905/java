package Thread;

public class Demo01GetThreadName {

	public static void main(String[] args) {
		//����Thread����������
		Mythread01 mt = new Mythread01();
		mt.start();
		mt.setName("����");
		
		new Mythread01().start();
		new Mythread01().start();
		//�������߳�
		new  Mythread01("xiaoqiang").start();

	}

}
