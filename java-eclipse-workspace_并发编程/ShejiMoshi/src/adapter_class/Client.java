package adapter_class;
//��computer���в�û���ṩ����TFCard��Ķ�ȡ����
public class Client {
     public static void main(String[] args) {
    	 Computer computer = new Computer();
    	 String msg = computer.readSD(new SDCardImpl());
    	 System.out.println(msg);
    	 
    	System.out.println("==========="); 
    	//ʹ�øĵ��Զ�ȡTF���е�����
    		//������������
    	String msg1 = computer.readSD(new TFadapter());
    	System.out.println(msg1);
     }
}
