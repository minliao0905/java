package java_awt;

public class point {
    private int x;
    private int y;
    public point() {
    	
    }
    public point(int x,int y) {
    	super();
    	this.x= x;
    	this.y= y;
    }
    public int getlastX() {
    	return x;
    }
    public int getlastY() {
    	return y;
    }
    @Override
    public String toString() {
    	return "x = " +x +",y = "+ y;
    }
}
