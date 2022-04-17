package java_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import javax.swing.*;
public class SimpleDraw {
    private final String RECT_SHAPE="rect";
    private final String OVAL_SHAPE="oval";
    Frame   frame = new Frame("������Ի�ͼ");
    Button brect =  new Button("����");
    Button boval = new Button("��Բ");
    
    private String shape="";
    MyCanvas drawArea = new MyCanvas();   //������������
    public void  init() {
    	//��װ��ͼ��
    	//��ť��Ӽ����¼���
    	brect.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			     //�޸�ֵ
				shape = RECT_SHAPE;
				drawArea.repaint();
				
			}
    		
    	});
    	boval.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			     //�޸�ֵ
				shape = OVAL_SHAPE;
				drawArea.repaint();				
			}
    		
    	});
    	//����panel��
    	Panel p = new Panel();
    	p.add(brect);
    	p.add(boval);
    	frame.add(p,BorderLayout.SOUTH);
//    	���û����Ĵ�С
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
			//���Ʋ�ͬ��ͼ��
			if(shape.equals(RECT_SHAPE)) {
				g.setColor(Color.red);
				g.draw3DRect(100, 100, 40, 40, true);  //���θ�����ʾ���
				g.fill3DRect(100, 100, 40, 40, true);
				g.draw3DRect(0, 100, 40, 40, false);  //���θ�����ʾ���
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
