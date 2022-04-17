package leetcode02;

import java.util.Scanner;

public class new8 {

	public static void main(String[] args) {
	int n ;
	Scanner sc = new Scanner(System.in);
	n = sc.nextInt();
	System.out.println(findIntegers(n));
	

	}
	 public static int findIntegers(int n) {
	        int[] dp = new int[31];
	        dp[0] = dp[1] = 1;
	        for (int i = 2; i < 31; ++i) {
	            dp[i] = dp[i - 1] + dp[i - 2];
	        }

	        int pre = 0, res = 0;
	        for (int i = 29; i >= 0; --i) {
	            int val = 1 << i;
//	            System.out.println("val" +i+ ":"+ val);
	            if ((n & val) != 0) {
	                res += dp[i + 1];
	                System.out.println("dp" +i+ ":"+ dp[i+1]);
	                if (pre == 1) {
	                    break;
	                }
	                pre = 1;
	            } else {
	                pre = 0;
	            }

	            if (i == 0) {
	                ++res;
	            }
	        }

	        return res;
	    }

	 public static int findIntegers1(int n) {
			int count = n+1;	 
		 for(int i=0;i<=n;i++) {
			 String s = Into2(i);
			 if(s.contains("11"))
			 {
				 System.out.println("nj" + i);
			 }
		 }
		return count;
	    }
     public static String Into2(int n) {
    	 StringBuffer s = new StringBuffer();
    	 int a =0,b=0,m;
    	 if(n == 0)
    	 {
    		 System.out.println("当前数字转换为s:" + 0);
    		 return "0";
    	 }
    	 while(n>0) {
    		m = n%2;
    		n = n/2;
    		s.append(m);
    	 }
    	 s = s.reverse();
    	 System.out.println("当前数字转换为s:" + s);
    	 return s.toString();
     }
}
