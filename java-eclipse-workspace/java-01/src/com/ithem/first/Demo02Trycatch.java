package com.ithem.first;

import java.io.*;

public class Demo02Trycatch {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			//���ܲ����쳣�Ĵ���	
			readFile("d:\\a.txt");
				
			  }
		catch(FileNotFoundException e) {
			//�쳣�Ĵ����߼�
			System.out.println(e);
		}finally {
			
			System.out.println("��Դ�ͷ�");
			//1.finally���ܵ���ʹ�ã���tryһ��ʹ��
			//2.finallyһ��������Դ���գ� ���۳����Ƿ�����쳣��
		}
			
	}
	 public static void readFile(String fileName) throws FileNotFoundException{
		 if(!fileName.endsWith(".txt")) {
			 throw new FileNotFoundException("���ݵ��ļ���׺������c:\\a.txt");
		 }
		 System.out.println("·��û������!");
	 }
}
