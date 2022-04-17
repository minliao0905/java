package tetris_game;


import java.awt.Graphics;

public abstract class AbstractBox {
	//设置形状
	//方块返回类型为图形
	public abstract void getShape(int x,int y,Graphics g,int kind);
	public abstract String getName();

	
}
