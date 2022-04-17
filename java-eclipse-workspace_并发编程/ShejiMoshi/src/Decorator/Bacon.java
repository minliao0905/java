package Decorator;

public class Bacon extends Garnish{

	public Bacon(FastFood fastfood) {
		super(2,"���",fastfood);
		
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
