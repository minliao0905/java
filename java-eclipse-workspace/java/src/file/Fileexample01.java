package file;


import java.io.FileOutputStream;

public class Fileexample01 {
	public static void main(String[] args) throws Exception{
		FileOutputStream out = new FileOutputStream("out.txt", true);
		String str = " world";
		out.write(str.getBytes());
		out.close();
	}

}
