package pattern.factory;

public class Client {
  public static void main(String[] args) {
	  //创建咖啡店类
	  coffeeStore store = new coffeeStore();
	  
	  //点咖啡功能
	  coffee coffee = store.orderCoffe("latte");
	  System.out.println(coffee.getName());
  }
}
