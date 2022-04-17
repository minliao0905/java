package Text02;

import java.util.LinkedList;

public class Text02 {
	
	public static void main(String[] args) {
		MessageQueue queue = new MessageQueue(2);
		
		for(int i =0;i<3;i++) {
			int id  = i;
			new Thread(()->{
				queue.put(new Message(id, "值"+id));
			},"生产者"+i).start();
		}
		new Thread(()->{
		
		Message message = queue.take();
		System.out.println(message);
	},"消费者").start();
//		
	}

	
   
}

//消息队列类，java线程之前通信 
class MessageQueue{
	//消息的队列集合；
	private LinkedList<Message> list = new LinkedList<>();
	//队列容量
	private int capcity ;
	
	public MessageQueue(int capcity) {
		this.capcity = capcity;
	}
	//获取消息
	public Message  take(){
	
		synchronized(list) {
			//检查对象是否为空
			while(list.isEmpty()) {
				System.out.println(Thread.currentThread().getName()+"队列为空 -------");
			try {
				list.wait();     //线程等待，没有消息的时候。 
			}catch (InterruptedException e) {				
				e.printStackTrace();
			}
		    }
			
			//队列 取出消息
			System.out.println(Thread.currentThread().getName()+" take消息");
			list.notifyAll();
			Message message = list.removeFirst();
			return message;
		}
		
		
	}
	public void put(Message message) {
		synchronized(list) {
			//检查对象是否已满
			while(list.size() == capcity) {
				try {
					System.out.println(Thread.currentThread().getName()+"队列已满 ------");
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.addLast(message);
			System.out.println(Thread.currentThread().getName()+" put消息");
			list.notifyAll() ;    //唤醒-------所有消费者在等待。
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