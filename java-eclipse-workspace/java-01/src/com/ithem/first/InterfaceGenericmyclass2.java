package com.ithem.first;
import java.util.ArrayList;

//����ͨ�����ʹ��
//���͵������޶������޺����ޣ�
  //���������������ͣ�ʹ�ã����ܴ�������ʹ�� ��ֻ����Ϊ�����Ĳ���ʹ��
public class InterfaceGenericmyclass2 {
     public static void main(String[] args) {	 
    	ArrayList<String> list1 = new ArrayList<>();
    	 list1.add("hello!");
    	 list1.add("java!");
    	 
    	 ArrayList<Integer> list2 = new ArrayList<>();
    	 list2.add(12);
    	 list2.add(32);
    	 print(list1);
    	 print(list2);
     }
     public static void print(ArrayList<?> list) {
    	 for(int i=0;i<list.size();i++) {
    		 System.out.println(list.get(i));
    	 }
     }
//������Arraylist��ʹ��printʱ����
     
//     public static void print(ArrayList<String> list) {
//    	 for(int i=0;i<list.size();i++) {
//    		 System.out.println(list.get(i));
//    	 }
//     }
}
