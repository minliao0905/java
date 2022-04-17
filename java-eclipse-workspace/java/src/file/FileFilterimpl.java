package file;

import java.io.*;
public class FileFilterimpl implements FileFilter{
@Override
public boolean accept(File pathname) {
	if(pathname.isDirectory() ) {
		return true;
	}
	return pathname.getName().toLowerCase().endsWith(".java");	
}
	public static void main(String[] args) {
		

	}

}
