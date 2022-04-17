package Decorator;
//炒饭（具体构建的角色）
public class firedRice extends FastFood{

   public firedRice() {
	   super(10,"炒饭");
   }
	@Override
	public float cost() {
		
		return getPrice();
	}

}
