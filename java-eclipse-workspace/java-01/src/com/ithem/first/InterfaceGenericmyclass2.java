package com.ithem.first;
import java.util.ArrayList;

//泛型通配符的使用
//泛型的受限限定，上限和下限；
  //代表任意数据类型，使用：不能创建对象使用 ，只可作为方法的参数使用
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
//当两个Arraylist都使用print时报错！
     
//     public static void print(ArrayList<String> list) {
//    	 for(int i=0;i<list.size();i++) {
//    		 System.out.println(list.get(i));
//    	 }
//     }
}
