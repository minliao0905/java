package abstract_factory;

public abstract class coffee {
	
	public abstract String getName();
	
	//加糖
	public void addsuger() {
		System.out.println("加糖");
	}
	
	//加奶
	public void addMilk() {
		System.out.println("加奶");
	}
	

}
