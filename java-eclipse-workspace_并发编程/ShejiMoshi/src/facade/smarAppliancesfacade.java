package facade;
//��������
public class smarAppliancesfacade {
private  Light light;
private TV tv;
private Aircondition aircondition;
public smarAppliancesfacade() {
	light = new Light();
	tv = new TV();
	aircondition = new Aircondition();
}
//���Կ���
public void say(String message) {
	if(message.contains("��")) {
		on();
	}else if(message.contains("�ر�")) {
		off();
	}else {
		System.out.println("ʮ�ֱ�Ǹ����û������������˼");
	}
}
private void on() {
	light.on();
	tv.on();
	aircondition.on();
}
private void off() {
	light.off();
	tv.off();
	aircondition.off();
}
	
}
