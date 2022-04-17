package java_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Read_saveimage {
 private  Frame  frame = new Frame("ͼƬ�鿴��");
     //�����˵���
 		MenuBar menubar = new MenuBar();
 		Menu menu1 = new Menu("�ļ�(F)");
 		MenuItem open=new MenuItem("��");
 		MenuItem save = new MenuItem("����");
 		MenuItem  saveanother = new MenuItem("���Ϊ");
 		MenuItem Import = new MenuItem("����");
 		MenuItem Export = new MenuItem("����");
 		MenuItem close= new MenuItem("�ر�");
 		
 		Menu menu2 = new Menu("�༭(E)");
 		MenuItem  repeal =  new MenuItem("����");
 		MenuItem renew = new MenuItem("����");
 		MenuItem copy  = new MenuItem("����");
 		MenuItem paste = new MenuItem("ճ��");
 		
 		Menu menu3 = new Menu("��ʽ(O)");
 		MenuItem bold  = new MenuItem("�Ӵ�");
 		MenuItem underline = new MenuItem("�»���");
 		MenuItem Imagemenu = new MenuItem("ͼ��");
 		
 		Menu menu4 = new Menu("��ͼ");
 		Menu menu5 = new Menu("����");
 		Menu menu6 = new Menu("����");
 		
 		BufferedImage image ;
 		private class MyCanvas extends Canvas {
 			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
 			public void paint(Graphics g) {
 				g.drawImage(image,0,0,null);		
 			}
 		}
 		
 		MyCanvas drawArea =new  MyCanvas();
 public void init() {
	 
	 open.addActionListener(e->{
		 //���ļ��Ի���
		 FileDialog filedialog = new FileDialog(frame,"��ͼƬ",FileDialog.LOAD);
		 filedialog.setVisible(true);
		 
		 //�����û�ѡ��ͼƬ·���Լ�����
		 String dir = filedialog.getDirectory();
		 String fileName = filedialog.getFile();
		 
		 try {
			 image =  ImageIO.read(new File(dir,fileName));  //����imageIO��ȡͼƬ�ļ�
			 drawArea.repaint();
		 }catch(IOException ex) {
			 ex.printStackTrace();
		 }
		 
	 });
	 save.addActionListener(e->{
		 FileDialog filedialog = new FileDialog(frame,"����ͼƬ",FileDialog.SAVE);
		 filedialog.setVisible(true);
		 String dir = filedialog.getDirectory();
		 String fileName = filedialog.getFile();
		 try {
			 ImageIO.write(image,"JPG",new File(dir,fileName));
			 
		 }catch(IOException ex){
		   ex.printStackTrace();
	     }
	 });
	 
	 
	 
	 
	 //�����¼���
	 frame.addWindowListener(new WindowAdapter() {
		 @Override 
		 public void windowClosing(WindowEvent e) {
			 System.exit(0);
		 }
	 });
	
	 menu1.add(open);
	 menu1.add(save);
	 menu1.add(saveanother);
	 menu1.add(Import);
	 menu1.add(Export);
	 menu1.add(close);
	 menu2.add(repeal);
	 menu2.add(copy);
	 menu2.add(paste);
	 menu3.add(bold);
	 menu3.add(underline);
	 menu3.add(Imagemenu);
	 
	 menubar.add(menu1);
	 menubar.add(menu2);
	 menubar.add(menu3);
	 menubar.add(menu4);
	 menubar.add(menu5);
	 menubar.add(menu6);
	 frame.setBounds(200,200,800,700);
	 frame.setVisible(true);
	 frame.setMenuBar(menubar);
	 frame.add(drawArea);
//	 frame.pack();
 }
 public static void main(String[] args) {
	 new Read_saveimage().init();
 }
}
