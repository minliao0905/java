package pattern.factory_method;

public class Client {
  public static void main(String[] args) {
	  //�������ȵ����
	  coffeeStore store = new coffeeStore();
	  
	  //������������
//	 coffeeFactory factory =  new  AmericanCoffeefactory();  //��ʽ���ȹ���
	 coffeeFactory factory =  new  latteeCoffeeFactory(); 
	 store.setFactory(factory);
	
	  coffee coffee = store.orderCoffe();
	  System.out.println(coffee.getName());
  }
}
