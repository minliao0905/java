package JFrame;
import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;  

public class Myframe03 extends JFrame implements ActionListener {  
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	  JLabel Label1 = new JLabel("��Ȥ��");       
	  JCheckBox yuCheck = new JCheckBox("��ë��");   
	  JCheckBox pingCheck = new JCheckBox("ƹ����");   
	  JCheckBox singCheck = new JCheckBox("����");  
	  
	  JLabel Label2 = new JLabel("�Ա�");  
	  JRadioButton nanButton1 = new JRadioButton("��");  
	  JRadioButton nvButton2 = new JRadioButton("Ů");  
	  
	  JTextArea textArea = new JTextArea(10,30);  
	  
	  Myframe03()  
	  {  
	       super("��ҵ����");  
	       Container contentPane = getContentPane();       // ��ȡ������壬JFrame�޷�ֱ����������ҪgetContentPane()��ȡ��壬ֻ�����������ӣ�Ȼ��������������������� 
	       
	                     									//container ����   �����������������ȡ������container ��ֱ��������
	       JPanel northPanel = new JPanel();  
	       northPanel.setLayout(new GridLayout(2,1));        //��岼�֣�����һ��
	  
	       Box box1 = Box.createHorizontalBox();             
	       Box box2 = Box.createHorizontalBox();            
//Box��ʽ����ʹ�ð����������ӣ�һ����ˮƽ���ӡ�һ���Ǵ�ֱ����
//	       ���췽�����£�
//	       Box box=Box.createHorizontalBox()//����ˮƽ���Ӷ���
//	       Box box=Box.createVertiaclBox()//������ֱ���Ӷ���
//	            ���Ӵ����ú���add()�������ӵ���������
//	       2.���ÿؼ���������ַ���
//	       ����һ��Box.createHorizontalStrut(int width)//����������������Ŀ��
//	           Box.createVerticalStrut(int height)//����������������ľ���
//	      ��������Box.createHorizontalGlue()��Box.createVerticalGlue()����Ϊʹ�ؼ���(Box)���Զ�����ƽ���������У�
//	       Box.createHorizontalGlue()���õ�һ���ؼ�ʱ����һ���ؼ�һֱ�ڼܹ����Ϸ���
//	      ��������Box.createRigidArea(Dimension d)����Ӧ�ĸߺͿ�������
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
	       contentPane.add(northPanel, BorderLayout.NORTH);         //container��������������   
	       JScrollPane scrollPane = new JScrollPane(textArea);  
	       contentPane.add(scrollPane, BorderLayout.CENTER);       //�������������
	  
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
	                       textArea.append("��ë��" + "\n");   
	                  }  
	              }    
	              else if(e.getSource() == pingCheck)  
	              {  
	                  if(pingCheck.isSelected() == true)  
	                  {  
	                       textArea.append("ƹ����" + "\n");   
	                  }            
	              }   
	              else if(e.getSource() == singCheck)  
	              {  
	                  if(singCheck.isSelected() == true)  
	                  {  
	                       textArea.append("����" + "\n");   
	                  }   
	              }  
	              else if(e.getSource() == nanButton1)  
	              {  
	                 if(nanButton1 .isSelected() == true)  
	                 {  
	                       textArea.append("��" + "\n");   
	                 }   
	              }  
	  
	              else if(e.getSource() == nvButton2)  
	              {  
	                 if(nvButton2 .isSelected() == true)  
	                 {  
	                       textArea.append("Ů" + "\n");   
	                 }   
	              }  
	              else  
	              {    
	                  return;   
	              }  
	         }  
	  
	        
	}  
