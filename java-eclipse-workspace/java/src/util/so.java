package util;

import java.util.Arrays;

public class so{  
	
public static void main(String[] args) {
		
		 int[] nums = {1,3,2};
	         nextPermutation(nums);
	         for(int i=0;i<nums.length;i++) {
	        	 	 System.out.println(nums[i]);
	         }
	    //Comparator��һ���ӿڣ��������������Լ��������MyComparatorҪimplents�ýӿڣ�������extends Comparator
	
	     }
	private static void nextPermutation(int[] nums) {
		int n= nums.length;
	        if(n<=1){
	            return ;
	        }
	        int temp,i; 
	        for( i=n-2;i>=0;i--){
	            if(nums[i]<nums[i+1])           //��λ��Сֵ
	            {
	                 //�ҵ��ϴ���min��ֵ
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