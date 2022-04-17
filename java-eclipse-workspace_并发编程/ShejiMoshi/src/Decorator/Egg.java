package Decorator;

public class Egg extends Garnish{

	public Egg( FastFood fastfood) {
		super(1,"����",fastfood);
		
	}

	@Override
	public float cost() {		
		return getPrice()+ getFastfood().cost();    //�����ļ۸���Ͽ�͵ļ۸�		
	}
	@Override 
	public String getDesc() {
		return super.getDesc()+ getFastfood().getDesc();
	}

}
