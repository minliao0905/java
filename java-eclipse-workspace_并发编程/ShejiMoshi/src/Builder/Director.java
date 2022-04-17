package Builder;

public class Director {
     //声明Builder的类型
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	//组装自行车的功能
	public Bike construct() {
		builder.builderFrame();
		builder.builderSeat();
		return builder.createBike();
	}
}
