package java_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.*;
public class SimpleDraw {
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";
    Frame   frame = new Frame("这里测试绘图");
    Button brect =  new Button("矩形");
    Button boval = new Button("椭圆");
    
    private String shape="";
    MyCanvas drawArea = new MyCanvas();   //创建画布对象，
    public void  init() {
    	//组装视图；
    	//按钮添加监听事件；
    	brect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			     //修改值
				shape = RECT_SHAPE;
				drawArea.repaint();
				
			}
    		
    	});
    	boval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			     //修改值
				shape = OVAL_SHAPE;
				drawArea.repaint();				
			}
    		
    	});
    	//创建panel；
    	Panel p = new Panel();
    	p.add(brect);
    	p.add(boval);
    	frame.add(p,BorderLayout.SOUTH);
//    	设置画布的大小
    	drawArea.setPreferredSize(new Dimension(300,200));
    	frame.add(drawArea);
    	frame.pack();
//    	  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
    	frame.setVisible(true);
    }
	private  class MyCanvas extends Canvas{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			//绘制不同的图形
			if(shape.equals(RECT_SHAPE)) {
				g.setColor(Color.red);
				g.draw3DRect(100, 100, 40, 40, true);  //矩形高亮显示结果
				g.fill3DRect(100, 100, 40, 40, true);
				g.draw3DRect(0, 100, 40, 40, false);  //矩形高亮显示结果
				g.fill3DRect(0, 100, 40, 40, false);
			}
			if(shape.equals(OVAL_SHAPE)) {
				g.setColor(Color.green);
				g.drawOval(10, 10, 150, 100);
			}
		}
	}

	
	
	public static void main(String[] args) {
	new SimpleDraw().init();

	}

}
