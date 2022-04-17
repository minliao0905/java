package tetris_game;

import java.util.HashMap;


public class BoxFactory {
private HashMap<Integer,AbstractBox> map ;
	
	//��ʼ��������ʾ�ù����������¼���ķ���
	private BoxFactory() {
		map = new HashMap<Integer,AbstractBox>();   //map�д��box����
		map.put(1, new IBox());
		map.put(2, new LBox());
		map.put(3, new TBox());
	}
	//��ȡ�ù�������󷽷�  //���칤�������������󷽱���ã�
	public static BoxFactory getInstance() {
		return factory;
	}
	private static BoxFactory factory = new BoxFactory();
	
	//�������ƻ�ȡͼ�����,���ͻ��˵��÷��� �൱�ڻ�ȡ����
	public AbstractBox getShape(Integer num) {
		System.out.println("��ǰ�������飺"+ map.get(num).getName());
		return map.get(num);
	}
}
