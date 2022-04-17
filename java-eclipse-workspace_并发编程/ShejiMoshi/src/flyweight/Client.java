package flyweight;

public class Client {
 public static void main(String[] agrs) {
	 //获取图形对象
	 AbstractBox  box1= BoxFactory.getInstance().getShape("IBox");
	 box1.dispaly("灰色");
	 
	 AbstractBox  box2= BoxFactory.getInstance().getShape("LBox");
	 box2.dispaly("灰色");
	 
	 AbstractBox  box3= BoxFactory.getInstance().getShape("OBox");
	 box3.dispaly("灰色");
	//若在创建一个一样的图像，则两次创建的为同一个对象；
 }
}
