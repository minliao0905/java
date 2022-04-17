package interface01;

public class GenericInterImpl2 implements GenericInterface<String> {
    @Override
    public void method(String s) {
    	System.out.println(s);
    	System.out.println("这是impl2的输出！");
    }
}
