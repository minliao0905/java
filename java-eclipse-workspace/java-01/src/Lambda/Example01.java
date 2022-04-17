package Lambda;
@FunctionalInterface
interface Calcable{
	int calc(int num);
}
//定义类，并且定义一个静态方法
class Math {
	public static int abs(int num) {
		if(num<=0)
			return -num;
		else return num;
	}
}
public class Example01 {
   private static void printabs(int num, Calcable cal){
	   System.out.println(cal.calc(num));
   }
	public static void main(String[] args) {
//		静态方法使用
		//lambda表达式方式
		printabs(-10,n->Math.abs(n));
		//方法引用的方式
		printabs(-10,Math::abs);

	}

}
