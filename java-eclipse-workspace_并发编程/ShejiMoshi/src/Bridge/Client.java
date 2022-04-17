package Bridge;

public class Client {
  public static void main(String[] args) {
	  //创建操作系统对象
	  OpratingSystem window = new Windows(new Avfile());
	 window.videoplay("四小时内");
  }
}
