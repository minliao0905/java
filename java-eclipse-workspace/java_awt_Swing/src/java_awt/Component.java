package java_awt;

import java.awt.*;

import javax.swing.Box;


public class Component {
 
    
    public void init() {
    Frame frame = new Frame("���ǲ��Ի������");
    TextArea ta = new TextArea(5,10);
     Choice colorChoice = new Choice();
     CheckboxGroup cbg = new CheckboxGroup();
     
     Checkbox male = new Checkbox("��",cbg,false);
     Checkbox female = new Checkbox("Ů",cbg,true);
     Checkbox  isMarried = new Checkbox("�Ƿ��ѻ�");
     
     TextField tf = new TextField(20);
     Button ok = new Button("ȷ��");
     List colorList = new List(6,true);//�������;
    	//�ײ����
    	Box bBox = Box.createHorizontalBox();  
    	bBox.add(tf);
    	bBox.add(ok);
    	frame.setVisible(true);
    	frame.add(bBox,BorderLayout.SOUTH);
    	
    	colorChoice.add("��ɫ");
    	colorChoice.add("��ɫ");
    	colorChoice.add("��ɫ");
    	Box cBox = Box.createHorizontalBox();
    	cBox.add(colorChoice);
    	cBox.add(male);
    	cBox.add(female);
    	cBox.add(isMarried);
    	
    //�����װ��һ��
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
