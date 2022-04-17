package command;

public class Client {
	public static void main(String[] args) {
		//创建第一个订单对象
		Order order1 = new Order();
		order1.setDiningTable(1);
		order1.setFood("小杯可乐",1);
		order1.setFood("小可乐",1);
		order1.setFood("小杯可乐",1);
		
		Order order2 = new Order();
		order2.setDiningTable(3);
		order2.setFood("小杯可乐",1);
		order2.setFood("小可乐",1);
		order2.setFood("小杯可乐",1);
		
		SeniorChef receiver = new SeniorChef();
		//创建命令对象
		OrderCommand cmd1 = new OrderCommand(receiver,order1);
		OrderCommand cmd2 = new OrderCommand(receiver,order2);
		
		//创建调用者
		Waitor invoke = new Waitor();
		invoke.setCommand(cmd1);
		invoke.setCommand(cmd2);
		invoke.orderUp();
	}
}
