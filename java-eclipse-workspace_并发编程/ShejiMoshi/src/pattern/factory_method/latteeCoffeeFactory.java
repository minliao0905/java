package pattern.factory_method;


public class latteeCoffeeFactory implements coffeeFactory {

	@Override
	public LatteCoffee createCoffeefactory() {
		
		return new LatteCoffee();
	}

}
