package flyweight;

public class Client {
 public static void main(String[] agrs) {
	 //��ȡͼ�ζ���
	 AbstractBox  box1= BoxFactory.getInstance().getShape("IBox");
	 box1.dispaly("��ɫ");
	 
	 AbstractBox  box2= BoxFactory.getInstance().getShape("LBox");
	 box2.dispaly("��ɫ");
	 
	 AbstractBox  box3= BoxFactory.getInstance().getShape("OBox");
	 box3.dispaly("��ɫ");
	//���ڴ���һ��һ����ͼ�������δ�����Ϊͬһ������
 }
}
