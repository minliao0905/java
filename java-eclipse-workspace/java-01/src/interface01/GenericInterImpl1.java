package interface01;

public class GenericInterImpl1<I> implements GenericInterface<I> {
    @Override
    public void method(I i) {
    	
    	System.out.println(i);
    	    	
    	System.out.println("����impl1�������");
    }
}