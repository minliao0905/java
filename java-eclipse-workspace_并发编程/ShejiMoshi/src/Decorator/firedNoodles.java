package Decorator;

public class firedNoodles extends FastFood{
 public firedNoodles() {
	 super(12,"����");     //���ø��෽����������
 }
 
	@Override
	public float cost() {
		return getPrice();
	}
 
}
