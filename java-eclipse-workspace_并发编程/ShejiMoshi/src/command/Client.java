package command;

public class Client {
	public static void main(String[] args) {
		//������һ����������
		Order order1 = new Order();
		order1.setDiningTable(1);
		order1.setFood("С������",1);
		order1.setFood("С����",1);
		order1.setFood("С������",1);
		
		Order order2 = new Order();
		order2.setDiningTable(3);
		order2.setFood("С������",1);
		order2.setFood("С����",1);
		order2.setFood("С������",1);
		
		SeniorChef receiver = new SeniorChef();
		//�����������
		OrderCommand cmd1 = new OrderCommand(receiver,order1);
		OrderCommand cmd2 = new OrderCommand(receiver,order2);
		
		//����������
		Waitor invoke = new Waitor();
		invoke.setCommand(cmd1);
		invoke.setCommand(cmd2);
		invoke.orderUp();
	}
}
