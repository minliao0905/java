package proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
  //����Ŀ�����
	private TrainStation station = new TrainStation();
	
	public SellTickets  getProxyObject() {
		//���ش������
		//��������
		/*
		 * 1.������������ڼ��ش����࣬ͨ��Ŀ������ȡ�������
		 * 2.������ʵ�ֵĽӿڵ��ֽ������
		 * 3.�������ĵ��ô������
		 */
		SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
				station.getClass().getClassLoader(),
				station.getClass().getInterfaces(),
				new InvocationHandler() {
		   /*	Object proxy :������󣬼�proxyObject ������ͬһ��������invoke�����л�����ͬ
			*	Method method :�Խӿڵķ������з�װ��method����
			*   Object[] args :���÷�����ʵ�ʲ���
			*	
			*	����ֵ�������ķ���ֵ
			*/		
					public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
						
						System.out.println("invoke����ִ����");
						
						//ִ��Ŀ�����ķ���
						Object obj = method.invoke(station,args);
						return obj;
					}
				}
				);
			return proxyObject;
	}
}
