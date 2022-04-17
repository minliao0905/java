package pattern.factory_method;

public class AmericanCoffeefactory implements coffeeFactory {

	@Override
	public coffee createCoffeefactory() {
		
		return new AmericanCoffee();
	}

}
