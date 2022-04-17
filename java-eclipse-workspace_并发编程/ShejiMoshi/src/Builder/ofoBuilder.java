package Builder;

public class ofoBuilder extends Builder{

	
	@Override
	public void builderFrame() {
		bike.setFrame("铝合金车架");
		
	}

	@Override
	public void builderSeat() {
	   bike.setSeat("真皮座椅");
		
	}

	@Override
	public Bike createBike() {
		// TODO Auto-generated method stub
		return bike;
	}

}
