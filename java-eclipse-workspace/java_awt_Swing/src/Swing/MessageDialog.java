package Swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class MessageDialog {
      JFrame jf = new JFrame("������Ϣ�Ի���");
      JTextArea jta = new JTextArea(10,30);
      
      JButton btn = new JButton(new AbstractAction("�����Ի���") {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			//������Ϣ�Ի�����ʾ�ı��������������;
		String text = jta.getText();
		
		//������int Message ָ����Ϣ�Ի�������ͣ�������Ϣ��������Ϣ��������Ϣ��
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.PLAIN_MESSAGE);
		JOptionPane.showMessageDialog(jf ,text, "��Ϣ�Ի���",JOptionPane.ERROR_MESSAGE,new ImageIcon("img/white.gif"));
		}
    	  
      });
      public void init() {
    	  //��װ��ͼ
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
