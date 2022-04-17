package flyweight;

import java.util.HashMap;

public class BoxFactory {
	private HashMap<String,AbstractBox> map ;
	
	//初始化操作表示该工厂存在以下几类的方块
	private BoxFactory() {
		map = new HashMap<String,AbstractBox>();
		map.put("IBox", new IBox());
		map.put("LBox", new LBox());
		map.put("OBox", new OBox());
	}
	//获取该工厂类对象方法
	public static BoxFactory getInstance() {
		return factory;
	}
	private static BoxFactory factory = new BoxFactory();
	
	//根据名称获取图像对象,当客户端调用方法 相当于获取方块
	public AbstractBox getShape(String name) {
		return map.get(name);
	}
}
