package com.ithem.first;
//�Զ����쳣�ࣻ
public class RegisterException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//���һ���ղ����Ĺ��췽��
	public RegisterException() {
		
	}
	//���һ�����쳣��Ϣ�Ĺ��췽��
	//�����ڲ�����ø�����쳣��Ϣ�Ĺ��췽��
	public RegisterException(String message) {
		super(message);
	}
}