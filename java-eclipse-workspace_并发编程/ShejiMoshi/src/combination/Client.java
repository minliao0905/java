package combination;

public class Client {
 
	public static void  main(String[] args) {
		//�����˵���
		MenuComponent menu1 = new Menu("�˵�����",2);
		menu1.add(new MenuItem("ҳ�����",3));
		menu1.add(new MenuItem("չ���˵�",3));
		menu1.add(new MenuItem("�༭�˵�",3));
		
		MenuComponent menu2 = new Menu("Ȩ�޹���",2);
		menu2.add(new MenuItem("ҳ�����",3));
		menu2.add(new MenuItem("�ύ����",3));
		
		MenuComponent menu3 = new Menu("��ɫ����",2);
		menu3.add(new MenuItem("ҳ�����",3));
		menu3.add(new MenuItem("������ɫ",3));
		menu3.add(new MenuItem("�޸Ľ�ɫ",3));
		//����һ���˵�
		MenuComponent component = new Menu("ϵͳ����",1);
		component.add(menu1);
		component.add(menu1);
		component.add(menu1);
		component.print();  //��ӡ�˵�����
		
	}
}
