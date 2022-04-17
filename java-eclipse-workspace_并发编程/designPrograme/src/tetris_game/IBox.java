package tetris_game;


import java.awt.Color;
import java.awt.Graphics;


public class IBox extends AbstractBox {
	
	
	@Override
	public void getShape(int x,int y,Graphics g,int kind) {   //�ڻ��ڼ���
		if(kind == 1||kind==3) {
			 for(int i=0;i<3;i++) {
	    	Cell cell =new Cell();		   
	        cell.Display(g, x, y+i, Color.red);   //����
	       }	
		}else if(kind == 2||kind==4) {//����
			for(int i=0;i<3;i++) {
				Cell cell =new Cell();				
				cell.Display(g, x+i, y,  Color.red);
			}
		}
	   
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "IBox";
	}


	
	
	
}
