package combination;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent{
   //�˵����ж���Ӳ˵������Ӳ˵���
	private List<MenuComponent> menuComponentList = new ArrayList<MenuComponent>();
	public Menu(String name,int level) {
		this.name = name;
		this.level = level;
	}
	public void add(MenuComponent menuComponent) {
		menuComponentList.add(menuComponent);
	}
    public void remove(MenuComponent menuComponent) {
		menuComponentList.remove(menuComponent);
	}
    public MenuComponent getChild(int index) {
    	return super.getChild(index);
    }
    
	@Override
	public void print() {
		for(int i=0;i<level;i++) {
			System.out.print("+");
		}
		//��ӡ�Ӳ˵�
		System.out.println(name);
		for(MenuComponent component: menuComponentList) {
		component.print();
		}
		
	}

}
