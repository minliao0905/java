package Builder;


//�û�����Ҫ���Ĵ�������Ĺ��̣�ֻ��Ҫָ�Ӵ���
public class Cilent {
	public  static void  main(String[] args) {
		//����ָ���߶���
		Director director =  new  Director(new MobileBuilder());
		//��ָ������װ���г�
		Bike bike = director.construct();
		System.out.println(bike.getFrame());
	}
}
