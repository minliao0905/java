package Decorator;
//�ͻ�����  ���е�͵�����
public class Client_de {
 //��һ�ݳ���
	public static void main(String[] args) {
	FastFood firedrice = new firedNoodles();
	//���
	System.out.println(firedrice.getDesc() + " "+firedrice.cost()+"Ԫ" );
	
    //��һ������
	firedrice= new Egg(firedrice);
	
	System.out.println(firedrice.getDesc() + " "+firedrice.cost()+"Ԫ" );
	}
	
}
