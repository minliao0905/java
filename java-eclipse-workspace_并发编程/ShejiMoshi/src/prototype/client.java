package prototype;

public class client {
		public static void main(String[] args) throws CloneNotSupportedException {
			//创建一个原型类对象
			Realizetype realizetype = new Realizetype();
			
			//调用类中的clone方法进行对象的克隆
			Realizetype clone = realizetype.clone();
			//比较地址值；结果不为同一个对象，false；
			System.out.println("原型对象和克隆出来的对象是否是同一个对象？"+(realizetype == clone)) ;
			 
		}
}
