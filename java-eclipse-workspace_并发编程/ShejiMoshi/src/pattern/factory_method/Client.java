package pattern.factory_method;

public class Client {
  public static void main(String[] args) {
	  //创建咖啡店对象
	  coffeeStore store = new coffeeStore();
	  
	  //创建工厂对象
//	 coffeeFactory factory =  new  AmericanCoffeefactory();  //美式咖啡工厂
	 coffeeFactory factory =  new  latteeCoffeeFactory(); 
	 store.setFactory(factory);
	
	  coffee coffee = store.orderCoffe();
	  System.out.println(coffee.getName());
  }
}
