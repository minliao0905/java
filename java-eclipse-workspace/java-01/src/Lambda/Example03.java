package Lambda;
@FunctionalInterface
interface Animal{
	void shout();
}
interface Calcable01{
	//�в��з���ֵ�ĺ���ʽ�ӿ�
	int sum(int a,int b);
}
public class Example03 {
  
	public static void main(String[] args) {
	//�ֱ���������ʽ�ӿڽ��в���
		animalShout(()->System.out.println("�޲Σ��޷���ֵ�ĺ���ʽ�ӿڵ��ã�"));
		ShowSum(10,10,(x,y)->x+y);

	}
	private static void animalShout(Animal animal) {
		animal.shout();
	}
	private static void ShowSum(int x,int y,Calcable01 calculate) {
		System.out.println("x+y="+calculate.sum(x,y));		
	}

}
