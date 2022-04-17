package Notebook;

import java.util.ArrayList; //������  ArrayListΪ���������� StringΪԪ�ص�����
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
		return ""+i;//�����κ�Java���string  ʹSystem.outֱ���������  //���û��string����,���������
	}
}

public class NoteBook {
	
	private ArrayList<String> notes = new ArrayList<String>();
  public void add(String s) {
		  notes.add(s);
	}
  public void add(String s,int location) {
	  notes.add(location,s); 			//ֻΪString ��������
	
  }
  public int getSize(){
	  return notes.size();     //�����ڲ����Գ���
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
	  notes.toArray(a);  //notes�����ԣ������
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
	  HashSet<String> s = new HashSet<String>();     //��������,set
	  s.add("first");
	  s.add("first");
	  s.add("first3");
	  for(String k:s) {
		  System.out.println(k);
	  }
//	  Value[] a = new Value[10];
//	  for(int i=0;i<a.length;i++) {
//		  a[i] = new Value();   //a�а������󣬿��ԶԶ�������޸Ĳ�����������ͨ�����в���
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
//	  String[] a = new String[10];   //���������е�ÿ��Ԫ�ض��Ƕ���Ĺ�������Ƕ�����
//	  for(int i=0;i<ai.length;i++) {
//		  ai[i] = i;
//	  }
//	  for(int k : ai) {             //for-eachѭ��  k����������һ������Ʒ�����ڶ������鲻ͬ��
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
