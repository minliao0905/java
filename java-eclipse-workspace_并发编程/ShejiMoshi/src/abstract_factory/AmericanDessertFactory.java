package abstract_factory;
//��ʽ��ζ����Ʒ����
public class AmericanDessertFactory implements DessertFactory{
		
	public coffee createCoffee() {
		return new AmericanCoffee();
	}
	public Dessert createDessert() {
		return new MacheMouse();
	}
	
}
