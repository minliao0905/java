package interface01;
//不能通过接口实现类的对象来调用接口中的静态方法 即在接口调用
//正确：通过接口名称，直接调用其中的静态方法
public class demo03 {
 public static void main(String[] args) {
	
	 myinterfaceStatic.methodStatic();
	 myinterfaceStaticimpl impl=new myinterfaceStaticimpl();
	 impl.methodimplStatic01();
 }
}
