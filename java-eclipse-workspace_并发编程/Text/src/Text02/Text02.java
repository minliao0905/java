package Text02;

import java.util.LinkedList;

public class Text02 {
	
	public static void main(String[] args) {
		MessageQueue queue = new MessageQueue(2);
		
		for(int i =0;i<3;i++) {
			int id  = i;
			new Thread(()->{
				queue.put(new Message(id, "ֵ"+id));
			},"������"+i).start();
		}
		new Thread(()->{
		
		Message message = queue.take();
		System.out.println(message);
	},"������").start();
//		
	}

	
   
}

//��Ϣ�����࣬java�߳�֮ǰͨ�� 
class MessageQueue{
	//��Ϣ�Ķ��м��ϣ�
	private LinkedList<Message> list = new LinkedList<>();
	//��������
	private int capcity ;
	
	public MessageQueue(int capcity) {
		this.capcity = capcity;
	}
	//��ȡ��Ϣ
	public Message  take(){
	
		synchronized(list) {
			//�������Ƿ�Ϊ��
			while(list.isEmpty()) {
				System.out.println(Thread.currentThread().getName()+"����Ϊ�� -------");
			try {
				list.wait();     //�̵߳ȴ���û����Ϣ��ʱ�� 
			}catch (InterruptedException e) {				
				e.printStackTrace();
			}
		    }
			
			//���� ȡ����Ϣ
			System.out.println(Thread.currentThread().getName()+" take��Ϣ");
			list.notifyAll();
			Message message = list.removeFirst();
			return message;
		}
		
		
	}
	public void put(Message message) {
		synchronized(list) {
			//�������Ƿ�����
			while(list.size() == capcity) {
				try {
					System.out.println(Thread.currentThread().getName()+"�������� ------");
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.addLast(message);
			System.out.println(Thread.currentThread().getName()+" put��Ϣ");
			list.notifyAll() ;    //����-------�����������ڵȴ���
		}
	}
}
final class Message{
	private int id;
	private Object value;
	public Message(int id,String value) {
		this.id = id;
		this.value = value;
	}
	public int getId() {
		return id;
	}
	public Object getValue() {
		return  value;
	}
	
	@Override
	public String toString() {
		return "Message{" + "id=" + id +",value=" +value +"}";
	}
}