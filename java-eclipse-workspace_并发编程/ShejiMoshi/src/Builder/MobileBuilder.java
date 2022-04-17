package Builder;

public class MobileBuilder extends Builder{

	
	@Override
	public void builderFrame() {
		bike.setFrame("Ì¼ÏËÎ¬³µ¼Ü");
		
	}

	@Override
	public void builderSeat() {
	   bike.setSeat("ÕæÆ¤×ùÒÎ");
		
	}

	@Override
	public Bike createBike() {
		
		return bike;
	}

}
