package tetris_game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * 创建步骤
 * 1.创建窗口，窗口布局为左右布局
 * 2画图Graghics
 * 3画出格子
 *
 * */
public class client {
	JFrame jf = new JFrame("俄罗斯方块游戏");
	
    final int WIDTH = 800;
    final int HEIGHT = 800; 
    final int BLACK = 0;
    final int BLUE = 1;
    final int GREEN = 2;
    final int RED = 3;
    
    int  ROW = 29;
    int COL = 26;
    int[][] data = new int[ROW][COL];
    
	public void init() throws Exception {
		jf.setBounds(200,10,WIDTH,HEIGHT);
		jf.setLayout(new BorderLayout());
		
		JPanel jtop = new JPanel(new FlowLayout(FlowLayout.RIGHT,10,0));  //设置组件之间的间隔
		jf.add(jtop,BorderLayout.NORTH);	  	
		//创建菜单部分
		
		JButton m1  = new JButton("暂停/继续");
		JButton m2  = new JButton("结束游戏");
		m1.setContentAreaFilled(false);//设置按钮透明
		m1.setBorder(null);//取消边框
		m2.setContentAreaFilled(false);//设置按钮透明
		m2.setBorder(null);//取消边框
		jtop.add(m1);
		jtop.add(m2);

		
		//创建游戏操作按钮   
		JPanel jleft = new JPanel();
		jf.add(jleft,BorderLayout.EAST);
		Box vbox = Box.createVerticalBox();
//		JButton turnrbtn = new JButton("顺时针旋转90°");
//		JButton turnlbtn = new JButton("逆时针旋转90°");
		JButton leftbtn = new JButton("左移");
		JButton rightbtn = new JButton("右移");
		JButton downbtn = new JButton("加速下降");
//		 jleft.setBackground(new Color(240,255,255));  
		vbox.add(Box.createVerticalStrut(400));
//		vbox.add(turnrbtn);
//		vbox.add(Box.createVerticalStrut(10));
//		vbox.add(turnlbtn);
//		vbox.add(Box.createVerticalStrut(10));
		vbox.add(leftbtn);
		vbox.add(Box.createVerticalStrut(10));
		vbox.add(rightbtn);
		vbox.add(Box.createVerticalStrut(10));		
		vbox.add(downbtn);
		jleft.add(vbox);
		
		Filed field = new Filed(ROW,COL);
		for ( int row = 0; row<field.getHeight(); row++ ) {
			for ( int col = 0; col<field.getWidth(); col++ ) {				
				field.place(row, col, new Cell());
			}
		}
		
		PaintField  paint = new PaintField(field);
		paint.setBackground(Color.black);   //设置面板背景颜色为黑色
		jf.add(paint,BorderLayout.CENTER);	
		
		//暂停和继续键
		m1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(paint.isstart == false) {  
					paint.isstart = true;
				}else {
					paint.isstart = false;
				}
			}			
		});
		//结束键
		m2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			paint.isfailed = true;		
		
			}			
		});
		
		
		//左移
		leftbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paint.move = -1;				
			}
			
		});
		//右移
		rightbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paint.move = 1;				
			}
			
		});
		//加速下降
		downbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				paint.move = 2;				
			}			
		});
//		//顺时钟旋转
//		turnlbtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				paint.move = 3;				
//			}
//			
//		});
//		//逆时钟旋转
//		turnrbtn.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				paint.move = 4;				
//			}
//			
//		});
		jf.setVisible(true);
		jf.setResizable(false);
		jtop.setBackground(new Color(240,255,240));
		jleft.setBackground(new Color(240,255,240));
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	//当点击按钮事件，调用方法修改PaintField的内部值，在其内部的监听事件中监听值的修改然后进行相关的操作
	
	public static void main(String[] args) {
		try {
			new client().init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
