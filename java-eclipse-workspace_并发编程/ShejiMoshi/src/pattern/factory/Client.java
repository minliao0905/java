package pattern.factory;

public class Client {
  public static void main(String[] args) {
	  //�������ȵ���
	  coffeeStore store = new coffeeStore();
	  
	  //�㿧�ȹ���
	  coffee coffee = store.orderCoffe("latte");
	  System.out.println(coffee.getName());
  }
}
