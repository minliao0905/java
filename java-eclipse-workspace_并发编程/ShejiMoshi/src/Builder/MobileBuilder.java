package Builder;

public class MobileBuilder extends Builder{

	
	@Override
	public void builderFrame() {
		bike.setFrame("̼��ά����");
		
	}

	@Override
	public void builderSeat() {
	   bike.setSeat("��Ƥ����");
		
	}

	@Override
	public Bike createBike() {
		
		return bike;
	}

}
