package com.ithem.first;

import java.io.*;

public class Demo02Trycatch {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			//可能产生异常的代码	
			readFile("d:\\a.txt");
				
			  }
		catch(FileNotFoundException e) {
			//异常的处理逻辑
			System.out.println(e);
		}finally {
			
			System.out.println("资源释放");
			//1.finally不能单独使用，和try一起使用
			//2.finally一般用于资源回收， 无论程序是否出现异常；
		}
			
	}
	 public static void readFile(String fileName) throws FileNotFoundException{
		 if(!fileName.endsWith(".txt")) {
			 throw new FileNotFoundException("传递的文件后缀名不是c:\\a.txt");
		 }
		 System.out.println("路径没有问题!");
	 }
}
