
package facade;
//线程编程
public class Cilent {
	
	public static void main(String[] args) {
		smarAppliancesfacade facade = new smarAppliancesfacade();
		facade.say("打开家电");
	
		facade.say("关闭家电");
	}
}
