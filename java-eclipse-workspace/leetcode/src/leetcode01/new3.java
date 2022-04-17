package leetcode01;

import java.util.Scanner;

public class new3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		Scanner sc = new Scanner(System.in);
    	num = sc.nextInt();
    	System.out.println("¼ÆËã½á¹û£º"+ fib(num));
	}

	    public static int fib(int n) {
	    	if(n==1)
	    	return 1;
	        int sum =0;
	        int a=0,b=1;
	        for(int i=2;i<=n;i++){
	            sum = a + b;
	            a = b;
	            b = sum ;
	        }
	        return sum;
	    }


}
