package Builder;


//用户不需要关心创建构造的过程，只需要指挥创建
public class Cilent {
	public  static void  main(String[] args) {
		//创建指挥者对象
		Director director =  new  Director(new MobileBuilder());
		//让指挥者组装自行车
		Bike bike = director.construct();
		System.out.println(bike.getFrame());
	}
}
