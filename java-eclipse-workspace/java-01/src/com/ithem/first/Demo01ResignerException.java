package com.ithem.first;
//�Զ����쳣��
import java.util.Scanner;

public class Demo01ResignerException {
    static String[] usernames= {"����","����","����"};
    public static void main(String[] args) throws  RegisterException{
    	Scanner sc = new Scanner(System.in);
    	System.out.println("��������Ҫע����û�����");
    	String username = sc.next();
    	checkusername(username);
    	sc.close();
    	
    }
    public static void checkusername(String username) throws  RegisterException{
    	for(String name:usernames) {
    		if(name.equals(username)) {
    			//�쳣��ʹ��try catch �����׳��쳣ʱ�����账������jvm�����жϴ���
    			try {
    				throw new RegisterException("�ף����û����ѱ�ע��!");
    				
    			}catch(RegisterException e) {
    				e.printStackTrace();
    				return ;//����
    			}
    			
    			
    		}
    	}
    	System.out.println("��ϲ����ע��ɹ���");
    }
}
