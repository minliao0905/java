package pattern.factory;
//���ȵ�
public class coffeeStore {
   public coffee orderCoffe(String type) {
	   
	   SimpleCoffeeFactory factory = new  SimpleCoffeeFactory();
	   //���������ķ���
	   coffee coffee = factory.createCoffee(type);
	   //������
	   coffee.addMilk();
	   coffee.addsuger();
	   
	   return null;
   }
}
