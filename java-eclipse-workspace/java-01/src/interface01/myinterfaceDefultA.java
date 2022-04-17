package interface01;

public class myinterfaceDefultA implements myinterfaceDefault{
    @Override 
    public void methodAbs() {
    	System.out.println("实现了抽象方法，AAA");
    }
    public void methodDefault1(){
    	System.out.println("默认方法1");
    }
}
