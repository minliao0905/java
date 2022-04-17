package Decorator;
//抽象装饰者类
public abstract class Garnish extends FastFood{
 //声明快餐菜类的变量
	private FastFood fastfood;
 //创建对象时定义属性
public Garnish(float price, String desc, FastFood fastfood) {
	super(price, desc);    //调用父类方法设置属性
	this.fastfood = fastfood;
}

public FastFood getFastfood() {
	return fastfood;
}

public void setFastfood(FastFood fastfood) {
	this.fastfood = fastfood;
}
	
}
