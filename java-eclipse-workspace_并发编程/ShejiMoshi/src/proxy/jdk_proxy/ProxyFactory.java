package proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory {
  //声明目标对象
	private TrainStation station = new TrainStation();
	
	public SellTickets  getProxyObject() {
		//返回代理对象
		//三个参数
		/*
		 * 1.类加载器，用于加载代理类，通过目标对象获取类加载器
		 * 2.代理类实现的接口的字节码对象
		 * 3.代理对象的调用处理程序
		 */
		SellTickets proxyObject = (SellTickets)Proxy.newProxyInstance(
				station.getClass().getClassLoader(),
				station.getClass().getInterfaces(),
				new InvocationHandler() {
		   /*	Object proxy :代理对象，即proxyObject 对象是同一个对象，在invoke方法中基本不同
			*	Method method :对接口的方法进行分装的method对象
			*   Object[] args :调用方法的实际参数
			*	
			*	返回值，方法的返回值
			*/		
					public Object invoke(Object proxy,Method method,Object[] args) throws Throwable{
						
						System.out.println("invoke方法执行了");
						
						//执行目标对象的方法
						Object obj = method.invoke(station,args);
						return obj;
					}
				}
				);
			return proxyObject;
	}
}
