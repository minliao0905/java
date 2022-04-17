package JFrame;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class Myframe03 extends JFrame implements ActionListener {  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  JLabel Label1 = new JLabel("兴趣：");       
	  JCheckBox yuCheck = new JCheckBox("羽毛球");   
	  JCheckBox pingCheck = new JCheckBox("乒乓球");   
	  JCheckBox singCheck = new JCheckBox("唱歌");  
	  
	  JLabel Label2 = new JLabel("性别：");  
	  JRadioButton nanButton1 = new JRadioButton("男");  
	  JRadioButton nvButton2 = new JRadioButton("女");  
	  
	  JTextArea textArea = new JTextArea(10,30);  
	  
	  Myframe03()  
	  {  
	       super("作业窗口");  
	       Container contentPane = getContentPane();       // 获取内容面板，JFrame无法直接添加组件需要getContentPane()获取面板，只能在面板上添加，然后再内容面板上添加组件。 
	       
	                     									//container 容器   容纳组件和容器，获取面板后在container 中直接添加组件
	       JPanel northPanel = new JPanel();  
	       northPanel.setLayout(new GridLayout(2,1));        //面板布局，两行一列
	  
	       Box box1 = Box.createHorizontalBox();             
	       Box box2 = Box.createHorizontalBox();            
//Box盒式容器使用包括两种箱子：一种是水平箱子、一种是垂直箱子
//	       构造方法如下：
//	       Box box=Box.createHorizontalBox()//创建水平箱子对象
//	       Box box=Box.createVertiaclBox()//创建垂直箱子对象
//	            箱子创建好后，用add()把组件添加到箱子里面
//	       2.设置控件间隔的三种方法
//	       方法一、Box.createHorizontalStrut(int width)//设置左右两个组件的宽度
//	           Box.createVerticalStrut(int height)//设置上下两个组件的距离
//	      方法二：Box.createHorizontalGlue()和Box.createVerticalGlue()方法为使控件在(Box)中自动扩充平均分配排列，
//	       Box.createHorizontalGlue()设置第一个控件时，第一个控件一直在架构的上方。
//	      方法三：Box.createRigidArea(Dimension d)以相应的高和宽进行真充
	       box1.add(Box.createHorizontalStrut(3));  
	       box1.add(Label1 ); 
	       box1.add(yuCheck );  
	       box1.add(pingCheck );  
	       box1.add(singCheck);          
	       
	       ButtonGroup group = new ButtonGroup();    
	       group.add(nanButton1);  
	       group.add(nvButton2);   
	  
	       box2.add(Box.createHorizontalStrut(3));           
	       box2.add(Label2); 
	       box2.add(nanButton1);  
	       box2.add(nvButton2);           
	  
	       northPanel.add(box1);   
	       northPanel.add(box2);  
	       contentPane.add(northPanel, BorderLayout.NORTH);         //container容器容纳面板组件   
	       JScrollPane scrollPane = new JScrollPane(textArea);  
	       contentPane.add(scrollPane, BorderLayout.CENTER);       //添加组件至容器里，
	  
	       yuCheck.addActionListener(this);   
	       pingCheck.addActionListener(this);   
	       singCheck.addActionListener(this);   
	       nanButton1.addActionListener(this);  
	       nvButton2.addActionListener(this);    
	  
	       setVisible(true);  
	       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	       setSize(400, 300);  
	       }  
	  
	  public static void main(String args[])  
      {  
           new Myframe03();  
      }  
	  
public void actionPerformed(ActionEvent e)  
{  
	              if(e.getSource() == yuCheck)  
	              {  
	                  if(yuCheck.isSelected() == true)  
	                  {  
	                       textArea.append("羽毛球" + "\n");   
	                  }  
	              }    
	              else if(e.getSource() == pingCheck)  
	              {  
	                  if(pingCheck.isSelected() == true)  
	                  {  
	                       textArea.append("乒乓球" + "\n");   
	                  }            
	              }   
	              else if(e.getSource() == singCheck)  
	              {  
	                  if(singCheck.isSelected() == true)  
	                  {  
	                       textArea.append("唱歌" + "\n");   
	                  }   
	              }  
	              else if(e.getSource() == nanButton1)  
	              {  
	                 if(nanButton1 .isSelected() == true)  
	                 {  
	                       textArea.append("男" + "\n");   
	                 }   
	              }  
	  
	              else if(e.getSource() == nvButton2)  
	              {  
	                 if(nvButton2 .isSelected() == true)  
	                 {  
	                       textArea.append("女" + "\n");   
	                 }   
	              }  
	              else  
	              {    
	                  return;   
	              }  
	         }  
	  
	        
	}  
