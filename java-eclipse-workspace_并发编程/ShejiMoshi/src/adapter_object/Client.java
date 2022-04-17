package adapter_object;
//在computer类中并没有提供关于TFCard类的读取方法
public class Client {
     public static void main(String[] args) {
    	 Computer computer = new Computer();
    	 String msg = computer.readSD(new SDCardImpl());
    	 System.out.println(msg);
    	 
    	System.out.println("==========="); 
    	//使用改电脑读取TF卡中的数据
    	//创建适配器类对象
    	TFadapter tfadapter = new TFadapter(new TFcardImpl());
    	String msg1 = computer.readSD(tfadapter);
    	System.out.println(msg1);
     }
}
