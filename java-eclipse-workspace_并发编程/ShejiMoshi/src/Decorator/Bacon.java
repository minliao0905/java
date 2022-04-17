package Decorator;

public class Bacon extends Garnish{

	public Bacon(FastFood fastfood) {
		super(2,"培根",fastfood);
		
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
