package Builder;

public class Director {
     //����Builder������
	private Builder builder;
	
	public Director(Builder builder) {
		this.builder = builder;
	}
	
	//��װ���г��Ĺ���
	public Bike construct() {
		builder.builderFrame();
		builder.builderSeat();
		return builder.createBike();
	}
}
