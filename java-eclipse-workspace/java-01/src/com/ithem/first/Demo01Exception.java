package com.ithem.first;

import java.io.FileNotFoundException;

public class Demo01Exception {
  public static void main(String[] args) throws FileNotFoundException{
	readFile("d:\\a.txt");
  }
 public static void readFile(String fileName) throws FileNotFoundException{
	 if(!fileName.equals("c:\\a.txt")) {
		 throw new FileNotFoundException("���ݵ��ļ�·������c:\\a.txt");
	 }
	 System.out.println("·��û������!");
 }
}		 
