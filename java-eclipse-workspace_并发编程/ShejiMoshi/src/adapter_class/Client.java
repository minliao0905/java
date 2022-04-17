package adapter_class;
//在computer类中并没有提供关于TFCard类的读取方法
public class Client {
     public static void main(String[] args) {
    	 Computer computer = new Computer();
    	 String msg = computer.readSD(new SDCardImpl());
    	 System.out.println(msg);
    	 
    	System.out.println("==========="); 
    	//使用改电脑读取TF卡中的数据
    		//定义适配器类
    	String msg1 = computer.readSD(new TFadapter());
    	System.out.println(msg1);
     }
}
