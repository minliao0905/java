package java_awt;

import java.awt.*;

import javax.swing.Box;


public class Component {
 
    
    public void init() {
    Frame frame = new Frame("这是测试基本组件");
    TextArea ta = new TextArea(5,10);
     Choice colorChoice = new Choice();
     CheckboxGroup cbg = new CheckboxGroup();
     
     Checkbox male = new Checkbox("男",cbg,false);
     Checkbox female = new Checkbox("女",cbg,true);
     Checkbox  isMarried = new Checkbox("是否已婚");
     
     TextField tf = new TextField(20);
     Button ok = new Button("确定");
     List colorList = new List(6,true);//组件容器;
    	//底部组件
    	Box bBox = Box.createHorizontalBox();  
    	bBox.add(tf);
    	bBox.add(ok);
    	frame.setVisible(true);
    	frame.add(bBox,BorderLayout.SOUTH);
    	
    	colorChoice.add("红色");
    	colorChoice.add("蓝色");
    	colorChoice.add("绿色");
    	Box cBox = Box.createHorizontalBox();
    	cBox.add(colorChoice);
    	cBox.add(male);
    	cBox.add(female);
    	cBox.add(isMarried);
    	
    //左边组装在一起；
    Box	leftBox =  Box.createVerticalBox();
    leftBox.add(ta);
    leftBox.add(cBox);
    
    Box top = Box.createHorizontalBox();
    top.add(leftBox);
    top.add(colorList);
    
    frame.add(top);
    frame.pack();

    frame.setVisible(true);
//    ((JFrame) frame).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    }  
	public static void main(String[] args) {
		new Component().init();
	}

}
