package pattern.factory;
//咖啡店
public class coffeeStore {
   public coffee orderCoffe(String type) {
	   
	   SimpleCoffeeFactory factory = new  SimpleCoffeeFactory();
	   //调用生产的方法
	   coffee coffee = factory.createCoffee(type);
	   //加配料
	   coffee.addMilk();
	   coffee.addsuger();
	   
	   return null;
   }
}
