package file;
import java.io.*;
public class Demo01Filter {

	public static void getAllFile(File dir) {
//		System.out.println(dir);
//��һ��
		File[] files=dir.listFiles(pathname->pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java")||pathname.getName().toLowerCase().endsWith(".txt"));
//�ڶ���
//		File[] files=dir.listFiles(new FileFilter() {
//			@Override 
//			public boolean accept(File pathname) {
//				return pathname.isDirectory()||pathname.getName().toLowerCase().endsWith(".java");
//			}
//		});
//������
//		File[] files=dir.listFiles(new FileFilterimpl());
//		for(File f:files) {
//			if(f.isDirectory()) {
//				//������ļ��У�������ļ���
//				getAllFile(f);
//			}else {
//				System.out.println(f);
//			}
//		}
		
		for(File f:files) {
			if(f.isDirectory()) {
				//������ļ��У�������ļ���
				getAllFile(f);
			}else {
				System.out.println(f);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          File file = new File("D:\\java-eclipse-workspace\\java\\src\\file");
          getAllFile(file);
	}

}
