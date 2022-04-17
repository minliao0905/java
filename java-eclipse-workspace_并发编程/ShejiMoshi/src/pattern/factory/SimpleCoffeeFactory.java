package pattern.factory;
//简单咖啡工厂，用来生产咖啡
public class SimpleCoffeeFactory {
	
	public coffee createCoffee(String type) {
		 //声明coffee类型的变量
		   coffee coffee=null;
		   if("american".equals(type)) {
			   coffee = new AmericanCoffee();
		   }else if("latte".equals(type)){
			   coffee = new LatteCoffee();
		   }else {
			   throw new RuntimeException("你所点的咖啡没有");
		   }
		return coffee;
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
