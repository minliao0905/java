package interface01;

public class demo01 {
    public static void main(String[] args) {
      //myinterface inter = new myinterface;  接口不能直接使用
 	   
 	   myinterfaceImpl impl = new myinterfaceImpl();
 	   impl.methodAbs1();
    }
}
