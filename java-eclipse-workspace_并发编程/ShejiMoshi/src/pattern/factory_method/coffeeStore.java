package pattern.factory_method;
//咖啡店
public class coffeeStore {
	 //声明私有工厂对象
	   private coffeeFactory factory;
	   
	   public void setFactory(coffeeFactory factory) {
		   this.factory = factory;
	   }
	 //点咖啡功能 
   public coffee orderCoffe() {
	  factory.createCoffeefactory();
	  coffee coffee = factory.createCoffeefactory();
	  coffee.addMilk();
	  
	   return coffee;
   }
}
