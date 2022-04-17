package java_awt;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Read_saveimage {
 private  Frame  frame = new Frame("图片查看器");
     //创建菜单条
 		MenuBar menubar = new MenuBar();
 		Menu menu1 = new Menu("文件(F)");
 		MenuItem open=new MenuItem("打开");
 		MenuItem save = new MenuItem("保存");
 		MenuItem  saveanother = new MenuItem("另存为");
 		MenuItem Import = new MenuItem("导入");
 		MenuItem Export = new MenuItem("导出");
 		MenuItem close= new MenuItem("关闭");
 		
 		Menu menu2 = new Menu("编辑(E)");
 		MenuItem  repeal =  new MenuItem("撤销");
 		MenuItem renew = new MenuItem("重做");
 		MenuItem copy  = new MenuItem("复制");
 		MenuItem paste = new MenuItem("粘贴");
 		
 		Menu menu3 = new Menu("格式(O)");
 		MenuItem bold  = new MenuItem("加粗");
 		MenuItem underline = new MenuItem("下划线");
 		MenuItem Imagemenu = new MenuItem("图像");
 		
 		Menu menu4 = new Menu("视图");
 		Menu menu5 = new Menu("主题");
 		Menu menu6 = new Menu("帮助");
 		
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
		 //打开文件对话框；
		 FileDialog filedialog = new FileDialog(frame,"打开图片",FileDialog.LOAD);
		 filedialog.setVisible(true);
		 
		 //根据用户选择图片路径以及名称
		 String dir = filedialog.getDirectory();
		 String fileName = filedialog.getFile();
		 
		 try {
			 image =  ImageIO.read(new File(dir,fileName));  //利用imageIO获取图片文件
			 drawArea.repaint();
		 }catch(IOException ex) {
			 ex.printStackTrace();
		 }
		 
	 });
	 save.addActionListener(e->{
		 FileDialog filedialog = new FileDialog(frame,"保存图片",FileDialog.SAVE);
		 filedialog.setVisible(true);
		 String dir = filedialog.getDirectory();
		 String fileName = filedialog.getFile();
		 try {
			 ImageIO.write(image,"JPG",new File(dir,fileName));
			 
		 }catch(IOException ex){
		   ex.printStackTrace();
	     }
	 });
	 
	 
	 
	 
	 //监听事件；
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
