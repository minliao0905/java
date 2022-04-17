package Swing;

import java.awt.Dimension;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SplitPaneTest {

	Book[] books = {new Book("java��ѧ����", new ImageIcon("swing\\img\\container\\java.png"), "���ڹ��� Java �����ȫ���ͼ�� \n ���ö� �� ѧ�û�"),

            new Book("��������JAVAEE��ҵӦ��ʵս", new ImageIcon("swing\\img\\container\\ee.png"), "SSM���Ͽ����ľ���ͼ�飬ֵ��ӵ��"),

            new Book("Android�����̳�", new ImageIcon("swing\\img\\container\\android.png"), "ȫ�����Androidƽ̨Ӧ�ó���\n �����ĸ�����֪ʶ")

    };
	JFrame jf = new JFrame("����JsplitPane");
	//�����������õ������
	JList<Book> bookJList = new JList<>(books);
	JLabel bookCover = new JLabel();

    JTextArea bookDesc = new JTextArea();
   public void init() {
	   //��װ��ͼ
	   //�趨�����С
	   bookJList.setPreferredSize(new Dimension(150,400));
       bookCover.setPreferredSize(new Dimension(220,270));
       bookDesc.setPreferredSize(new Dimension(220,130)); 
       //ΪjList������Ŀѡ�м�����
       bookJList.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
           @Override
           public void valueChanged(ListSelectionEvent e) {
               //��ȡ��ǰѡ�е����ĸ���Ŀ
               Book book = bookJList.getSelectedValue();
               //���鼮��ͼƬ��bookCoverչʾ
               bookCover.setIcon(book.getIcon());

               //���鼮��������bookDescչʾ
               bookDesc.setText(book.getDesc());
           }
       });
       
       //��װ�������
       JSplitPane left = new JSplitPane(JSplitPane.VERTICAL_SPLIT,bookCover,new JScrollPane(bookDesc));

       left.setOneTouchExpandable(true);


       //��װ����
       JSplitPane hole = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,left,bookJList);

       //֧����������
       hole.setContinuousLayout(true);
       hole.setDividerSize(10);

       jf.add(hole);

       jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       jf.pack();
       jf.setVisible(true);

   }
	public static void main(String[] args) {
	     new SplitPaneTest().init();

	}

}
