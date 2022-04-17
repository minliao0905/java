package flyweight;

import java.util.HashMap;

public class BoxFactory {
	private HashMap<String,AbstractBox> map ;
	
	//��ʼ��������ʾ�ù����������¼���ķ���
	private BoxFactory() {
		map = new HashMap<String,AbstractBox>();
		map.put("IBox", new IBox());
		map.put("LBox", new LBox());
		map.put("OBox", new OBox());
	}
	//��ȡ�ù�������󷽷�
	public static BoxFactory getInstance() {
		return factory;
	}
	private static BoxFactory factory = new BoxFactory();
	
	//�������ƻ�ȡͼ�����,���ͻ��˵��÷��� �൱�ڻ�ȡ����
	public AbstractBox getShape(String name) {
		return map.get(name);
	}
}
