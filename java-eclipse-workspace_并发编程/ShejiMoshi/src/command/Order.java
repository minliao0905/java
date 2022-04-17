package command;

import java.util.HashMap;
import java.util.Map;

public class Order {
 
	//��������
	private int diningTable;
	//���µĲ�Ʒ������
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
