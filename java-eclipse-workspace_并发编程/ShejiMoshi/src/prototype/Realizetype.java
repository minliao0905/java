package prototype;
//克隆类
public class Realizetype implements Cloneable{
	public Realizetype(){
		System.out.println("具体的原型对象创建完成");
	}
 public Realizetype clone() throws CloneNotSupportedException{
	System.out.println("具体对象复制成功");
	 return   (Realizetype) super.clone();   //该方法中返回object类
	 
 }
}
