package tetris_game;

import java.awt.Color;
import java.awt.Graphics;

public class LBox extends AbstractBox {

	@Override
	public void getShape(int x, int y, Graphics g,int kind) {
		if(kind == 1) {
			for(int i=0;i<3;i++) {
				Cell cell =new Cell();    	
		        cell.Display(g, x, y+i, Color.blue);
		    }
			Cell cell =new Cell();    
	     cell.Display(g, x+1, y+2, Color.blue);
	     
		}else if(kind == 2) {
		  for(int i=0;i<3;i++) {
				Cell cell =PaintField.theField.get(x+i, y+1);	
			  cell.isalive = true;
			  cell.Display(g, x+i, y, null);
		  }
			Cell cell =PaintField.theField.get(x+2, y);	
		  cell.isalive = true;
		  cell.Display(g, x+2, y, Color.blue);
	  }else if(kind == 3) {
		  for(int i=0;i<3;i++) {
				Cell cell =PaintField.theField.get(x+1, y+i);	
			  cell.isalive = true;
			  cell.Display(g, x+1, y+i, null);
		  }
			Cell cell =PaintField.theField.get(x, y);	
		  cell.isalive = true;
		  cell.Display(g, x, y, Color.blue);
	  }else if(kind == 4) {
		  for(int i=0;i<3;i++) {
				Cell cell =PaintField.theField.get(x+i, y);	
			  cell.isalive = true;
			  cell.Display(g, x+i, y, null);
		  }
			Cell cell =PaintField.theField.get(x+1, y);	
		  cell.isalive = true;
		  cell.Display(g, x+1, y, Color.blue);
	  }
	}
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "LBox";
	}


	


}
