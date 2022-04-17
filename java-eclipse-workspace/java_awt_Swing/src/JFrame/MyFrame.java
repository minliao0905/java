package JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;



public class MyFrame implements MouseListener,ActionListener {
    JFrame frame =new JFrame(); 
    JPanel jp = new JPanel();
     JLabel jl = new JLabel("juahu");
       public  String s="单击鼠标即可显示鼠标当前坐标";
	public MyFrame() {
		setFrame();
	}
	private  void setFrame() {
		  
			 frame.setSize(500,400);
		     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		     frame.setVisible(true);   		    
		     jp.addMouseListener(this);
		     frame.setResizable(false);
//		     frame.getMousePosition();
		      jp.add(jl);
		      jl.setText(s);
		       System.out.println("hghg:"+s);//只执行一次
		      frame.add(jp);
		
	}
	public static void main(String[] args) {
		
		new MyFrame();

	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		 int x =e.getX();
		 int y = e.getY();
		 s = "鼠标坐标："+"("+x+","+y+")";
		  System.out.println(s);
		  jl.setText(s);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {

	    
	       System.out.println("hghg:"+s);
	}

}
