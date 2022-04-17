package JFrame;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Myframe02 extends JFrame implements MouseListener,ActionListener {
   
	public static void main(String[] args) {
		 new Myframe02();
	}
	
	private static final long serialVersionUID = 1L;
	    JPanel jp1 = new JPanel();  
	    JLabel jl = new JLabel();
	    public  String s="单击鼠标即可显示鼠标当前坐标"; 
	
	   
	     JLabel jl1 = new JLabel("兴趣：") ;
	     JCheckBox jbox1 = new JCheckBox("羽毛球");
	     JCheckBox jbox2 = new JCheckBox("乒乓球");
	     JCheckBox jbox3 = new JCheckBox("唱歌"); 
	     
	     JLabel jl2 = new JLabel("性别：");  
	     JRadioButton  jrb1 =  new JRadioButton("男");
	     JRadioButton  jrb2 =  new JRadioButton("女");
	     
	    
	     JTextArea textArea = new JTextArea(10,30);  

	public Myframe02(){
    	 CreateFrame();
    	 setFrame();  
     }
	 private void CreateFrame() {
		// TODO Auto-generated method stub
		  JFrame frame = new JFrame();
     	  frame.setTitle("菜单组件和box盒式容器");	
     	
     	  
          frame.setSize(500,500);   //窗体尺寸定义
     	  
     	  Container contentPane = this.getContentPane();
     	  JPanel panel = new JPanel();
     	  
     	  panel.setLayout(new GridLayout(2,1));
     	  
     	  //创建Box容器
     	  Box box1 = Box.createHorizontalBox();
     	  Box box2 = Box.createHorizontalBox();
     	  
     	  box1.add(Box.createHorizontalStrut(3));   
     	  box1.add(jl1);
     	  box1.add(jbox1);
     	  box1.add(jbox2);
     	  box1.add(jbox3); 
     		
     	  
     	  ButtonGroup group = new ButtonGroup();    
	       group.add(jrb1);  
	       group.add(jrb2);   
     	  box2.add(Box.createHorizontalStrut(3));    
     	  box2.add(jl2);
     	  box2.add(jrb1);
     	  box2.add(jrb2);
     
     	    
     	  panel.add(box1);    //面板中添加组件
     	  panel.add(box2);
     	  
     	  //添加面板至容器中；
     	 
     	
     	 
	       JScrollPane scrollPane = new JScrollPane(textArea);  
	       panel.add(scrollPane, BorderLayout.CENTER);       //添加组件至容器里，
     	   contentPane.add(panel,BorderLayout.NORTH);
	      frame.setVisible(true); 
	     
	   
	     //添加至jp1面板  //同一个组件不可以同时加入两个面板，同一块钱不可存入两个银行；
//	     jp1.add(jl1);
//	     jp1.add(jbox1);
//	     jp1.add(jbox2);
//	     jp1.add(jbox3);
//	     jp1.add(jl2);
//	     jp1.add(jrb1);
//	     jp1.add(jrb2);
//	   
	     //添加监听事件
         jbox1.addActionListener(this); 
         jbox2.addActionListener(this); 
         jbox3.addActionListener(this); 
         jrb1.addActionListener(this); 
         jrb2.addActionListener(this);
        
//         JScrollPane jsc = new  JScrollPane(textArea);
//         jp1.add(jsc);
//         frame.add(jp1);
         frame.add(panel);
         frame.setSize(500, 300);  
	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	 
	
		
		private  void setFrame() {
	    //整个面板添加监听事件
			     jp1.addMouseListener(this);
			     jp1.add(jl);
			     jl.setText(s);		
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
		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//
            if(e.getSource() == jbox1)  
            {  
                if(jbox1.isSelected() == true)  
                {  
                     textArea.append("羽毛球" + "\n");   
                }  
            }    
            else if(e.getSource() == jbox2)  
            {  
                if(jbox2.isSelected() == true)  
                {  
                     textArea.append("乒乓球" + "\n");   
                }            
            }   
            else if(e.getSource() == jbox3)  
            {  
                if(jbox3.isSelected() == true)  
                {  
                     textArea.append("唱歌" + "\n");   
                }   
            }  
            else if(e.getSource() == jrb1)  
            {  
               if(jrb1 .isSelected() == true)  
               {  
                     textArea.append("男" + "\n");   
               }   
            }  

            else if(e.getSource() == jrb2)  
            {  
               if(jrb2 .isSelected() == true)  
               {  
                     textArea.append("女" + "\n");   
               }   
            }  
            else  
            {    
                return;   
            }  
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

}
