package com.one.util;

public class PathUtils {

	//相对路径创建
    private static final String P_PATH="images/";

    public static String getRealPath(String relativePath){

        return P_PATH+relativePath;
    }

}
