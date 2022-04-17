package abstract_factory;
//美式风味的甜品工厂
public class AmericanDessertFactory implements DessertFactory{
		
	public coffee createCoffee() {
		return new AmericanCoffee();
	}
	public Dessert createDessert() {
		return new MacheMouse();
	}
	
}
