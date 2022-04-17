package leetcode01;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class new2 {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		long start=System.currentTimeMillis(); //获取开始时间
		Random r = new Random();
			int[] arr= new int[1000];
		for(int i=0;i<1000;i++) {
			arr[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(arr));
		
		int k = r.nextInt(10);
	    int[] rs = new int[10];
	    rs = smallestK(arr,10);
	    long end=System.currentTimeMillis(); //获取结束时间
	  	    System.out.println(Arrays.toString(rs));
	  	    System.out.println("程序运行时间： "+(end-start)+"ms");
	}
	 public static  int[] smallestK(int[] arr, int k) {
         Arrays.sort(arr);
         int[] rs = new int[k];
         for(int i=0;i<k;i++){
             rs[i] = arr[i];
         }
         return rs;
 }

}
