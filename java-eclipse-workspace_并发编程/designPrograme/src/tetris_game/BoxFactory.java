package tetris_game;

import java.util.HashMap;


public class BoxFactory {
private HashMap<Integer,AbstractBox> map ;
	
	//初始化操作表示该工厂存在以下几类的方块
	private BoxFactory() {
		map = new HashMap<Integer,AbstractBox>();   //map中存放box对象
		map.put(1, new IBox());
		map.put(2, new LBox());
		map.put(3, new TBox());
	}
	//获取该工厂类对象方法  //制造工厂产生工厂对象方便调用；
	public static BoxFactory getInstance() {
		return factory;
	}
	private static BoxFactory factory = new BoxFactory();
	
	//根据名称获取图像对象,当客户端调用方法 相当于获取方块
	public AbstractBox getShape(Integer num) {
		System.out.println("当前生产方块："+ map.get(num).getName());
		return map.get(num);
	}
}
