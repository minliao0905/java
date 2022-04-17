package command;

import java.util.HashMap;
import java.util.Map;

public class Order {
 
	//餐桌号码
	private int diningTable;
	//所下的餐品及份数
	private Map<String,Integer> foodDir = new HashMap<String,Integer>();
	

	public Order(int diningTable, Map<String, Integer> foodDir) {
		super();
		this.diningTable = diningTable;
		this.foodDir = foodDir;
	}
	public Order() {
		
	}

	public int getDiningTable() {
		return diningTable;
	}

	public void setDiningTable(int diningTable) {
		this.diningTable = diningTable;
	}

	public Map<String, Integer> getFoodDir() {
		return foodDir;
	}

	public void setFood(String name,int num) {
		foodDir.put(name, num);
	}
	

}
