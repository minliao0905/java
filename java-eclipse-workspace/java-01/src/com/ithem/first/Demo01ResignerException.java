package com.ithem.first;
//自定义异常类
import java.util.Scanner;

public class Demo01ResignerException {
    static String[] usernames= {"张三","李四","王五"};
    public static void main(String[] args) throws  RegisterException{
    	Scanner sc = new Scanner(System.in);
    	System.out.println("请输入您要注册的用户名：");
    	String username = sc.next();
    	checkusername(username);
    	sc.close();
    	
    }
    public static void checkusername(String username) throws  RegisterException{
    	for(String name:usernames) {
    		if(name.equals(username)) {
    			//异常不使用try catch 运行抛出异常时，无需处理，交给jvm处理，中断处理
    			try {
    				throw new RegisterException("亲，该用户名已被注册!");
    				
    			}catch(RegisterException e) {
    				e.printStackTrace();
    				return ;//结束
    			}
    			
    			
    		}
    	}
    	System.out.println("恭喜您，注册成功！");
    }
}
