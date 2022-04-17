package Decorator;

public class Egg extends Garnish{

	public Egg( FastFood fastfood) {
		super(1,"鸡蛋",fastfood);
		
	}

	@Override
	public float cost() {		
		return getPrice()+ getFastfood().cost();    //鸡蛋的价格加上快餐的价格		
	}
	@Override 
	public String getDesc() {
		return super.getDesc()+ getFastfood().getDesc();
	}

}
