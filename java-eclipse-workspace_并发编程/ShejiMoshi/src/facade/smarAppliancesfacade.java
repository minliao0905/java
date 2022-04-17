package facade;
//智能音箱
public class smarAppliancesfacade {
private  Light light;
private TV tv;
private Aircondition aircondition;
public smarAppliancesfacade() {
	light = new Light();
	tv = new TV();
	aircondition = new Aircondition();
}
//语言控制
public void say(String message) {
	if(message.contains("打开")) {
		on();
	}else if(message.contains("关闭")) {
		off();
	}else {
		System.out.println("十分抱歉，我没有听懂您的意思");
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
