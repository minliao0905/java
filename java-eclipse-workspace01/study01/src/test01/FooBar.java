package test01;
class FooBar {
     private int    n;
	  private volatile boolean isFoo;

	    public FooBar(int n) {
	        this.n = n;
	    }

	    public synchronized void foo(Runnable printFoo) throws InterruptedException {

	        for (int i = 0; i < n; i++) {
	            printFoo.run();
	            isFoo = true;
	            this.notify();
	            if (i < n - 1) {
	                this.wait();
	            }
	        }
	    }

	    public synchronized void bar(Runnable printBar) throws InterruptedException {
	        if (!isFoo) {	        	
	            this.wait();
	        }
	        for (int i = 0; i < n; i++) {
	            printBar.run();
	         System.out.println("当前的线程数i："+ i);
	            this.notify();
	            if (i < n - 1) { 	            	
	                this.wait();
	            }
	        }
	    }
}

