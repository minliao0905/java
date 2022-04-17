package Notebook;

import java.util.ArrayList; //容器类  ArrayList为容器的类型 String为元素的类型
import java.util.HashSet;
class Value{
	private int i;
	public void set(int i) {
		this.i=i;
	}
	public int get() {
		return i;
	}
	public String toString() {
		return ""+i;//对与任何Java类的string  使System.out直接输出对象  //如果没有string定义,则输出不明
	}
}

public class NoteBook {
	
	private ArrayList<String> notes = new ArrayList<String>();
  public void add(String s) {
		  notes.add(s);
	}
  public void add(String s,int location) {
	  notes.add(location,s); 			//只为String 其他不行
	
  }
  public int getSize(){
	  return notes.size();     //容器内部属性长度
  }
  public String getNote(int index) {
	  return notes.get(index);
  }
  public void removeNote(int index) {
	 notes.remove(index);
  }
  public String[] List() {
	  String[] a = new String[notes.size()];
//	  for(int i=0;i<notes.size();i++) {
//		  a[i]=notes.get(i);
//	  }
	  notes.toArray(a);  //notes的属性，，填充
	  return a;
  }
  public static void main(String[] args) {
	  Value v = new Value();
	  v.set(10);
	  System.out.println(v);
	  ArrayList<String> a = new ArrayList<String>();
	  a.add("first");
	  a.add("first");
	  a.add("first3");
	  a.add("first3");
	  for(String s:a) {
		  System.out.println(s);
	  }
	  System.out.println(a);
	  System.out.println("----------------------");
	  HashSet<String> s = new HashSet<String>();     //集合容器,set
	  s.add("first");
	  s.add("first");
	  s.add("first3");
	  for(String k:s) {
		  System.out.println(k);
	  }
//	  Value[] a = new Value[10];
//	  for(int i=0;i<a.length;i++) {
//		  a[i] = new Value();   //a中包含对象，可以对对象进行修改操作，而在普通数组中不可
//		  a[i].set(i);
//	  }
//	  for(Value v:a) {
//		  System.out.println(v.get());
//		  
//	  }
//	  for(Value v : a) {
//		  System.out.println(v.get());
//		  v.set(0);
//	  }
	  
	  
//	  int[] ai = new int[10];
//	  String[] a = new String[10];   //对象数组中的每个元素都是对象的管理这而非对象本身
//	  for(int i=0;i<ai.length;i++) {
//		  ai[i] = i;
//	  }
//	  for(int k : ai) {             //for-each循环  k对于数组是一个复制品，对于对象数组不同；
//		  System.out.println(k);
//	  }
	  
	  
//	  NoteBook nb=new NoteBook();
//	  nb.add("first");
//	  nb.add("first3");
//	  nb.add("second",1);
//	  System.out.println(nb.getSize());
//	  System.out.println(nb.getNote(0));
//	  String[] a;
//	  a = nb.List();
//	  for(String s:a) {
//		  System.out.println(s);
//	  }
  }
}
