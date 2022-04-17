package leetcode01;

import java.util.Scanner;

public class new04 {

	public static void main(String[] args) {
		String s ;
		Scanner sc = new Scanner(System.in);
    	s= sc.next();
    	
       System.out.println("½á¹ûÊÇ£º"+ balancedStringSplit(s));
       

	}
	   public static int balancedStringSplit(String s) {
	        int rs=0;int k=0;
	        for(int i=0;i<s.length();i++){
	            
	            if(s.charAt(i)== 'R'){
	                k++;
	            }else if(s.charAt(i)=='L'){
	                k--;
	            }
	            if(k==0){
	                rs++;
	            }
	        }
	        return rs;
	    }
}
