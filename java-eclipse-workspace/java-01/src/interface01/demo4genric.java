package interface01;

public class demo4genric {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericInterImpl2 gi2 = new GenericInterImpl2();
        gi2.method("impl2µÄ×Ö·û´®");
        
        GenericInterImpl1<String> gi1 = new GenericInterImpl1<>();
        gi1.method("9");
        
        GenericInterImpl1<Integer> gi3 = new GenericInterImpl1<>();
        gi3.method(90);
	}

}
