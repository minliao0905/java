package test01;

public class print{
	
public static void main(String[] args) {
	    FooBar p = new FooBar(10);
	    		new Thread( ){
	    			public void run() {
	    			try {
						p.foo(new Print_Foo());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    			}
	    		}.start();
	    		new Thread( ){
	    			public void run() {
	    			try {
						p.bar(new Print_Bar());
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
	    			}
	    		}.start();
		}
	}

class Print_Bar implements Runnable{

	@Override
	public void run() {
		System.out.print("Bar");		
	}
}


class Print_Foo implements Runnable{

	@Override
	public void run() {
		System.out.print("Foo");
	}
}

