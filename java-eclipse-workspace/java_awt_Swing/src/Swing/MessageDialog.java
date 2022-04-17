package Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MessageDialog {
      JFrame jf = new JFrame("测试消息对话框");
      JTextArea jta = new JTextArea(10,30);
      
      JButton btn = new JButton(new AbstractAction("弹出对话框") {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			//弹出消息对话框，显示文本域中输入的内容;
		String text = jta.getText();
		
		//参数，int Message 指定消息对话框的类型，错误消息，警告消息，问题消息；
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "消息对话框",JOptionPane.ERROR_MESSAGE,new ImageIcon("img/white.gif"));
		}
    	  
      });
      public void init() {
    	  //组装视图
    	  jf.add(jta);
    	  jf.add(btn,BorderLayout.SOUTH); 
    	  
    	  jf.setBounds(100,100,300,300);
    	  jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  jf.setVisible(true);
      }
	public static void main(String[] args) {
		new MessageDialog().init();

	}

}
