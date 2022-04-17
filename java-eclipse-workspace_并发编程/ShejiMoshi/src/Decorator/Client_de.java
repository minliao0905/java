package Decorator;
//客户端类  进行点餐的事项
public class Client_de {
 //点一份炒饭
	public static void main(String[] args) {
	FastFood firedrice = new firedNoodles();
	//输出
	System.out.println(firedrice.getDesc() + " "+firedrice.cost()+"元" );
	
    //加一个鸡蛋
	firedrice= new Egg(firedrice);
	
	System.out.println(firedrice.getDesc() + " "+firedrice.cost()+"元" );
	}
	
}
