package proxy.jdk_proxy;

public class Client {
	public static void mian(String[] args) {
		//获取代理对象
		//创建代理工厂对象
		ProxyFactory factory = new ProxyFactory();
		//使用factory对象的方法获取代理对象
		SellTickets proxyObject  = factory.getProxyObject();
		//调用类调用的方法
		proxyObject.sell();
	}
}
