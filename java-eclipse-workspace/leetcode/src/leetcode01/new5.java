package leetcode01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
//������ʵ˼·�򵥣��Ȳ���̰���㷨��ʹÿ���о����ܶ�ĵ��ʣ�Ȼ���ڷ��ÿո�
//����ä����ע��
// ���һ��Ҫ����룬����֮��ֻ�����һ���ո������ʳ��־��"." ����Ҫ�ո񣬽��������һ������ƴ�ӡ�
//���ͽ���Ч������Ҫ��һ����ǣ���������������ֵ�ı仯����Ҫ��������ȷ�����������н���˼·���������ܶ�Сϸ��û��ע�⵽���ǳ����ä��
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
					int lastspace = (maxWidth-num)-(semp-i-1); ///ע�����һ�е�ĩβ�������䲻�ܷŵ�����ִ�У�Ҫ��i�ı�֮ǰȷ��lastspace��ֵ���˴�����һ������û��ע�⵽i��ֵ�����˸ı�������������˿ո�
					//�ٴ��ύ����ԭ�򣬿ո�����(maxWidth-num)-(semp-i-1)������ (maxWidth-num)-(semp-i)��
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
			 //�������һ�������
			ans.add(temp); 
		 }
		  
		return ans;
          
	    }
	  // blank ���س���Ϊ n ���ɿո���ɵ��ַ���
	    public static String blank(int n) {
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < n; ++i) {
	            sb.append('-');
	        }
	        return sb.toString();
	    }

}