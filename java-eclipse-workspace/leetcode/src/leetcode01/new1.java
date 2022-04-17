package leetcode01;

import java.util.Arrays;
import java.util.Scanner;

public class new1 {
    static String version1;
	static String version2;
    public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	version1 = sc.next();
    	version2 = sc.next();
//    	System.out.println(version1);
    	sc.close();
     System.out.println("比较结果显示如下" + compareVersion(version1,version2));
    	
    }
    public static int compareVersion(String version1, String version2) {
        //不合格的版本号，直接返回0.
        if(version1.length()<=0||version2.length()<=0)
    return 0;
    String[] ve1 = version1.split("\\.");
    String[] ve2 = version2.split("\\.");
  
    	// System.out.println(ve1.toString());
     	// System.out.println(ve2.toString());
     	int i=0;
     	for( i=0;i<ve1.length;i++) {
            
     		int num = Integer.parseInt(ve1[i]);
     		int num2 =0;
             if(i==ve2.length&&num!=0){
              return 1;
             }
     		else if(i<ve2.length) {
     			 num2 = Integer.parseInt(ve2[i]);
     		}                
     		if(num<num2)
     			return -1;
     		else if(num>num2)
     		    return 1;        
            
     	}
        while(i<ve2.length){
         int    num2 = Integer.parseInt(ve2[i]);
             if(num2!=0)
             return -1;
             i++;
             }
    return 0;

}
}
