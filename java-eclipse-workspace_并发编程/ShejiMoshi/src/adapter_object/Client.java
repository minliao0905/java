package adapter_object;
//��computer���в�û���ṩ����TFCard��Ķ�ȡ����
public class Client {
     public static void main(String[] args) {
    	 Computer computer = new Computer();
    	 String msg = computer.readSD(new SDCardImpl());
    	 System.out.println(msg);
    	 
    	System.out.println("==========="); 
    	//ʹ�øĵ��Զ�ȡTF���е�����
    	//���������������
    	TFadapter tfadapter = new TFadapter(new TFcardImpl());
    	String msg1 = computer.readSD(tfadapter);
    	System.out.println(msg1);
     }
}
