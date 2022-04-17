package interface01;
//从java8开始，接口中允许定义默认方法；
public interface myinterfaceDefault {
//接口当中的默认方法，可以解决接口升级的问题；
 public abstract void methodAbs();
// 新添加的方法 改成默认方法
 public default void methodDefault() {
	 System.out.println("这是新添加的默认方法！");
 }
}

