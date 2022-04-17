package tetris_game;

import java.awt.Color;

import java.awt.Graphics;
//画出方格图像
public class Cell {  //画出正方形
	public boolean isalive = false;    //是否有颜色
	private static final int GRID_SIZE = 25;   //方格大小
	public void draw(Graphics g, int x, int y) {
	   g.setColor(new Color(20,68,106));
//	   g.setFont(new Font("arial",Font.BOLD,10));  
	   g.drawRect(x*GRID_SIZE, y*GRID_SIZE, GRID_SIZE,GRID_SIZE);		
	
	}
	public void Display(Graphics g, int x, int y,Color color) {
		g.setColor(color);
		g.fillRect(x*GRID_SIZE, y*GRID_SIZE, GRID_SIZE,GRID_SIZE);	  //画方格颜色
		
	}
}
