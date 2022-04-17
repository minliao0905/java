package file;

import java.io.File;

public class Demo01file {

	public static void main(String[] args) {
		show01();

	}
	private static void show01() {
		
		File f1 = new File("D:\\java-eclipse-workspace\\java\\out.txt");
		System.out.println(f1);
		File f2 = new File("out.txt");
		System.out.println(f2);
		long l1 = f1.length();
		System.out.println(l1);
	}
}
