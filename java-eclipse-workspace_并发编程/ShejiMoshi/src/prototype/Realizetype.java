package prototype;
//��¡��
public class Realizetype implements Cloneable{
	public Realizetype(){
		System.out.println("�����ԭ�Ͷ��󴴽����");
	}
 public Realizetype clone() throws CloneNotSupportedException{
	System.out.println("��������Ƴɹ�");
	 return   (Realizetype) super.clone();   //�÷����з���object��
	 
 }
}
