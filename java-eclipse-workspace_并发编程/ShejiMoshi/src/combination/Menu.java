package combination;

import java.util.ArrayList;
import java.util.List;

public class Menu extends MenuComponent{
   //菜单项有多个子菜单或者子菜单项
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
		//打印子菜单
		System.out.println(name);
		for(MenuComponent component: menuComponentList) {
		component.print();
		}
		
	}

}
