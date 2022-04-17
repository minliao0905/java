package com.ithem.first;

import java.io.FileNotFoundException;

public class Demo01Exception {
  public static void main(String[] args) throws FileNotFoundException{
	readFile("d:\\a.txt");
  }
 public static void readFile(String fileName) throws FileNotFoundException{
	 if(!fileName.equals("c:\\a.txt")) {
		 throw new FileNotFoundException("传递的文件路径不是c:\\a.txt");
	 }
	 System.out.println("路径没有问题!");
 }
}		 
