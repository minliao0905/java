package Builder;

public abstract class Builder {
	
	//����bike���͵ı��� �������и���
	protected Bike bike = new Bike();
	
	public abstract void builderFrame();
	
	public abstract void builderSeat();
	
	//�������г��ķ���
	public abstract Bike createBike();
}
