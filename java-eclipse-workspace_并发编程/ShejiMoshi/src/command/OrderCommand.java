package command;

import java.util.Map;
import java.util.Set;

public class OrderCommand implements command{
 
	//���������߶���
	private  SeniorChef receiver;
	private Order order;
	
	public OrderCommand() {
		
	}
	public OrderCommand(SeniorChef receiver, Order order) {
		
		this.receiver = receiver;
		this.order = order;
	}
	public void execute() {
		System.out.println(order.getDiningTable()+"���Ķ���");
	    Map<String,Integer> foodDir = order.getFoodDir();
	    //����map����
	    Set<String> keys = foodDir.keySet();
	    for(String foodName:keys) {
	    	receiver.makeFood(foodName, foodDir.get(foodName));
	    	
	    }
	    System.out.println(order.getDiningTable()+"���ķ�׼�����!!!");
	}
	
}
