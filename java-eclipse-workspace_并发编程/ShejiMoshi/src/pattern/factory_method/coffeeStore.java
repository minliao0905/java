package pattern.factory_method;
//���ȵ�
public class coffeeStore {
	 //����˽�й�������
	   private coffeeFactory factory;
	   
	   public void setFactory(coffeeFactory factory) {
		   this.factory = factory;
	   }
	 //�㿧�ȹ��� 
   public coffee orderCoffe() {
	  factory.createCoffeefactory();
	  coffee coffee = factory.createCoffeefactory();
	  coffee.addMilk();
	  
	   return coffee;
   }
}
