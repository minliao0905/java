package tetris_game;


import java.awt.Graphics;

public abstract class AbstractBox {
	//������״
	//���鷵������Ϊͼ��
	public abstract void getShape(int x,int y,Graphics g,int kind);
	public abstract String getName();

	
}
