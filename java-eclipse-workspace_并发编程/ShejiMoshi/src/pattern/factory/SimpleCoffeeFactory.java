package pattern.factory;
//�򵥿��ȹ�����������������
public class SimpleCoffeeFactory {
	
	public coffee createCoffee(String type) {
		 //����coffee���͵ı���
		   coffee coffee=null;
		   if("american".equals(type)) {
			   coffee = new AmericanCoffee();
		   }else if("latte".equals(type)){
			   coffee = new LatteCoffee();
		   }else {
			   throw new RuntimeException("������Ŀ���û��");
		   }
		return coffee;
		  
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
