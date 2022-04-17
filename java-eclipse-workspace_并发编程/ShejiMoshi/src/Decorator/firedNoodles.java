package Decorator;

public class firedNoodles extends FastFood{
 public firedNoodles() {
	 super(12,"炒面");     //调用父类方法定义类型
 }
 
	@Override
	public float cost() {
		return getPrice();
	}
 
}
