package Thread;
//�����̵߳�����
/*
 * 1ʹ��Thread��ķ���setName(���֣�;    void  setName(String name)�ı��߳����� ʹ֮�����name��ͬ
 * 2.����һ���������Ĺ��췽��
 * 
 */
public class Mythread01 extends Thread{
@Override
	public void run() {
		//��ȡ�߳�����
	//String name = getName();
	//System.out.println(name);
	Thread t = Thread.currentThread();
	System.out.println(t);
    
	String name = t.getName();
	System.out.println(name);
	
	
//��ʽд��	System.out.println(Thread.currentThread().getName());
	
	}

//�ø��������
public Mythread01() {}
public   Mythread01(String name) {
	super(name);
}
}
