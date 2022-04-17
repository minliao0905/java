package leetcode01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
//本题其实思路简单，先采用贪心算法，使每行有尽可能多的单词，然后在放置空格
//本题盲点需注意
// 最后一行要左对齐，单词之间只需插入一个空格，若单词出现句号"." 则不需要空格，将单词与后一个单词拼接。
//拉低解题效率最重要的一点就是，不清楚代码各处的值的变化，需要多次输出才确认下来，还有解题思路不清晰，很多小细节没有注意到。非常多的盲点
public class new5 {
	public static void main(String[] args) {
		int k,w;
		
		Scanner sc = new Scanner(System.in);
//		ArrayList<String> strArray = new ArrayList<String> (); 
	
		int i=0;
		int num = 16;
 String[] str = {"ask","not","what","your","country","can","do","for","you","ask","what","you","can","do","for","your","country"};
   
     List<String> rs = fullJustify(str,num);
     for(String s:rs) {
    	 System.out.println(s);
     }
    	
sc.close();
	
	}
	  public static List<String> fullJustify(String[] words, int maxWidth) {
		 int i,semp =0,n = words.length;
		 List<String> ans = new ArrayList<String>();
		 for(semp=0;semp<n;) {
			 int num=0;i=semp;
			 while(semp<n) {
				 if(num+words[semp].length()+(semp-i)<=maxWidth){	
					
					 num +=words[semp].length();
					 semp++;
				 }else {
					 break;
				 }
			 }
			 String temp="";	
			 if(num==maxWidth)
			 {
			   for(;i<semp;i++) {
				   temp += words[i];
			   }
			 }else {
				if(semp-i==1) {
					temp+=words[i];
					temp+=blank(maxWidth-num);
					
				}else if(semp==n) {
					int lastspace = (maxWidth-num)-(semp-i-1); ///注意最后一行的末尾，这个语句不能放到后面执行，要在i改变之前确认lastspace的值，此处犯了一个错误，没有注意到i的值发生了改变以至于最后多加了空格
					//再次提交错误原因，空格数是(maxWidth-num)-(semp-i-1)而不是 (maxWidth-num)-(semp-i)；
					for(;i<semp-1;i++) {
						temp+=words[i];
						temp+=blank(1);
					}
					temp+=words[i];
					temp+=blank(lastspace);
					System.out.println("qw"+num+"  "+ i+semp);
				}
				else {
				int ansapace = (maxWidth-num)/(semp-i-1);
				System.out.println("qw"+ansapace +"  "+ i+semp);
				int extraspace = (maxWidth-num)%(semp-i-1);
				int count =0;
				for(i=i;i<semp-1;i++) {
					temp+=words[i];
					temp+=blank(ansapace);
					if(count<extraspace) {
						count++;
						temp+=blank(1);
					}
				}
				temp+=words[i];
				}
			 }
			 //考虑最后一行左对齐
			ans.add(temp); 
		 }
		  
		return ans;
          
	    }
	  // blank 返回长度为 n 的由空格组成的字符串
	    public static String blank(int n) {
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < n; ++i) {
	            sb.append('-');
	        }
	        return sb.toString();
	    }

}