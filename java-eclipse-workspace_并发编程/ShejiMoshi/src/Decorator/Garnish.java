package Decorator;
//����װ������
public abstract class Garnish extends FastFood{
 //������Ͳ���ı���
	private FastFood fastfood;
 //��������ʱ��������
public Garnish(float price, String desc, FastFood fastfood) {
	super(price, desc);    //���ø��෽����������
	this.fastfood = fastfood;
}

public FastFood getFastfood() {
	return fastfood;
}

public void setFastfood(FastFood fastfood) {
	this.fastfood = fastfood;
}
	
}
