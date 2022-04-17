package Lambda;
@FunctionalInterface
interface Calcable{
	int calc(int num);
}
//�����࣬���Ҷ���һ����̬����
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
//		��̬����ʹ��
		//lambda���ʽ��ʽ
		printabs(-10,n->Math.abs(n));
		//�������õķ�ʽ
		printabs(-10,Math::abs);

	}

}
