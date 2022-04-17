package util;

import java.util.Arrays;

public class so{  
	
public static void main(String[] args) {
		
		 int[] nums = {1,3,2};
	         nextPermutation(nums);
	         for(int i=0;i<nums.length;i++) {
	        	 	 System.out.println(nums[i]);
	         }
	    //Comparator是一个接口，所以这里我们自己定义的类MyComparator要implents该接口，而不是extends Comparator
	
	     }
	private static void nextPermutation(int[] nums) {
		int n= nums.length;
	        if(n<=1){
	            return ;
	        }
	        int temp,i; 
	        for( i=n-2;i>=0;i--){
	            if(nums[i]<nums[i+1])           //后位较小值
	            {
	                 //找到较大于min的值
	            	 System.out.println(Arrays.toString(nums));
	            for(int j=n-1;j>=i;j--){
	                if(nums[j]>nums[i])
	                {
	                  temp=nums[j];
	                  nums[j]=nums[i];
	                  nums[i] = temp;
	             	 System.out.println(Arrays.toString(nums));
	                   Arrays.sort(nums,i+1,n);
	                   return ;
	                }
	            } 
	            }
	        }
	        
	        Arrays.sort(nums);
	            return ;
	}

}