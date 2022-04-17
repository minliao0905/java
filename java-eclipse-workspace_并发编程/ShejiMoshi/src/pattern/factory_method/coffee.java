package pattern.factory_method;

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
	public static void main(String[] args) {
		

	}

}
