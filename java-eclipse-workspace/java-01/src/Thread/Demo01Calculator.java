package Thread;

public class Demo01Calculator {

	public static void main(String[] args) {
		invokeCalc(10,20,new CalculatorImpl() {
			@Override 
			public int calc(int a,int b) {
				return a+b;
			}
		});
		invokeCalc(120,130,(int a,int b)->{
			return a-b;
		});
		invokeCalc(120,130,(a,b)-> a+b);
	}
	public static void invokeCalc(int a,int b,CalculatorInterface c) {
		int sum = c.calc(a, b);
		System.out.println("½á¹û="+sum);
	}

}
