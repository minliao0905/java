package List;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*如果导错包就会出现这样的错误
 * The type List is not generic; it cannot be parameterized with arguments <Integer>*/

public class List02 {
   static int ans=0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
      String ring = "godding";
      String key = "gd";
    
        ans =  findRotateSteps(ring,key);
//        System.out.println(ans);
	}
	 @SuppressWarnings("unchecked")
	public  static int findRotateSteps(String ring, String key) {
	        int n = ring.length(), m = key.length();
	        List<Integer>[] pos = new List[26];
	        for (int i = 0; i < 26; ++i) {
	            pos[i] = new ArrayList<Integer>();
	        }
	        for (int i = 0; i < n; ++i) {
	            pos[ring.charAt(i) - 'a'].add(i);           //ArrayList的add方法     boolean add<E e>
	        }
	        int[][] dp = new int[m][n];
	        for (int i = 0; i < m; ++i) {
	            Arrays.fill(dp[i], 0x3f3f3f);
	        }
	        for (int i : pos[key.charAt(0) - 'a']) {       // pos[key.charAt(0) - 'a']
	            dp[0][i] = Math.min(i, n - i) + 1;
	        }
	        for (int i = 1; i < m; ++i) {
	            for (int j : pos[key.charAt(i) - 'a']) {      
	                for (int k : pos[key.charAt(i - 1) - 'a']) {
	                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
	                }
	            }
	        }
	        
	        for(int i=0;i<26;i++) {
	        		System.out.print(pos[i]+" ");		
	        }
	    	System.out.println("");		
	        for(int i=0;i<m;i++) {
	        	for(int j=0;j<n;j++) {
	        		System.out.print(dp[i][j]+" ");
	        	}
	        	System.out.println("");		
	        }
	        return Arrays.stream(dp[m - 1]).min().getAsInt();
	    }
    


}
