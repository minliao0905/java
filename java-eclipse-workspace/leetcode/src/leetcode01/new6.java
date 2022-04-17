package leetcode01;

import java.util.Scanner;

public class new6 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] chalk = {5,1,5};
	  int k=22;
	  System.out.println(chalkReplacer(chalk,k));
	}

	 public static int chalkReplacer(int[] chalk, int k) {
         int i=0;
         int n = chalk.length;
         int sum =0 ;
         for(i=0;i<n;i++){
             sum+=chalk[i];
             if(sum>k){
            	 System.out.println("wewe");
                 return i;
             }
         }
         int rs = k%sum;
         System.out.println("wee" + rs);
         if(rs == 0)
        	 return 0;         
             k = rs;
             for(i=0;i<n;i++){               
                 if(k-chalk[i]<0)
                 {
                	 System.out.println("wew" + k);
                	 return i;
                 } 
                 k = k- chalk[i];
             }
         
         return 0;
 }
}
