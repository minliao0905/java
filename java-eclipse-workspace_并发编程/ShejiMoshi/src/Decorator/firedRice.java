package Decorator;
//���������幹���Ľ�ɫ��
public class firedRice extends FastFood{

   public firedRice() {
	   super(10,"����");
   }
	@Override
	public float cost() {
		
		return getPrice();
	}

}
