package tetris_game;

import java.awt.Color;

import java.awt.Graphics;
//��������ͼ��
public class Cell {  //����������
	public boolean isalive = false;    //�Ƿ�����ɫ
	private static final int GRID_SIZE = 25;   //�����С
	public void draw(Graphics g, int x, int y) {
	   g.setColor(new Color(20,68,106));
//	   g.setFont(new Font("arial",Font.BOLD,10));  
	   g.drawRect(x*GRID_SIZE, y*GRID_SIZE, GRID_SIZE,GRID_SIZE);		
	
	}
	public void Display(Graphics g, int x, int y,Color color) {
		g.setColor(color);
		g.fillRect(x*GRID_SIZE, y*GRID_SIZE, GRID_SIZE,GRID_SIZE);	  //��������ɫ
		
	}
}
