package Builder;

public abstract class Builder {
	
	//声明bike类型的变量 ，并进行复制
	protected Bike bike = new Bike();
	
	public abstract void builderFrame();
	
	public abstract void builderSeat();
	
	//构建自行车的方法
	public abstract Bike createBike();
}
