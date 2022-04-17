package Lambda;
@FunctionalInterface
interface Animal{
	void shout();
}
interface Calcable01{
	//有参有返回值的函数式接口
	int sum(int a,int b);
}
public class Example03 {
  
	public static void main(String[] args) {
	//分别两个函数式接口进行测试
		animalShout(()->System.out.println("无参，无返回值的函数式接口调用！"));
		ShowSum(10,10,(x,y)->x+y);

	}
	private static void animalShout(Animal animal) {
		animal.shout();
	}
	private static void ShowSum(int x,int y,Calcable01 calculate) {
		System.out.println("x+y="+calculate.sum(x,y));		
	}

}
