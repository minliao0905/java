package proxy.jdk_proxy;

public class Client {
	public static void mian(String[] args) {
		//��ȡ�������
		//��������������
		ProxyFactory factory = new ProxyFactory();
		//ʹ��factory����ķ�����ȡ�������
		SellTickets proxyObject  = factory.getProxyObject();
		//��������õķ���
		proxyObject.sell();
	}
}
