package Builder;

public class ofoBuilder extends Builder{

	
	@Override
	public void builderFrame() {
		bike.setFrame("���Ͻ𳵼�");
		
	}

	@Override
	public void builderSeat() {
	   bike.setSeat("��Ƥ����");
		
	}

	@Override
	public Bike createBike() {
		// TODO Auto-generated method stub
		return bike;
	}

}
