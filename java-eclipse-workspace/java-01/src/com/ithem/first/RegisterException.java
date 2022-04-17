package com.ithem.first;
//自定义异常类；
public class RegisterException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//添加一个空参数的构造方法
	public RegisterException() {
		
	}
	//添加一个带异常信息的构造方法
	//方法内部会调用父类带异常信息的构造方法
	public RegisterException(String message) {
		super(message);
	}
}