package tetris_game;

import java.awt.Color;
import java.awt.Graphics;

public class TBox extends AbstractBox{

	@Override
	public void getShape(int x, int y, Graphics g,int kind) {
		if(kind ==1) {
			 for(int i=0;i<3;i++) {
				 Cell cell =new Cell();	 		    
			        cell.Display(g, x+i, y, Color.green);
			    }
			 Cell cell = new Cell();		
		     cell.Display(g, x+1, y+1, Color.green);	
		}
		else if(kind == 2) {
			 for(int i=0;i<3;i++) {
				 Cell cell =PaintField.theField.get(x+1, y+i);   
			    	cell.isalive = true;
			        cell.Display(g, x+1, y+i, Color.green);
			    }
			 Cell cell =PaintField.theField.get(x, y+1);    
			 cell.isalive = true;
		     cell.Display(g, x, y+1, Color.green);	
		}else if(kind ==3) {
			 for(int i=0;i<3;i++){
				 Cell cell =PaintField.theField.get(x+i, y);
			    	cell.isalive = true;
			        cell.Display(g, x+i, y, Color.green);
			    }
			 Cell cell =PaintField.theField.get(x+1, y+1);	 
			 cell.isalive = true;
		     cell.Display(g, x+1, y+1, Color.green);	
		}else if(kind == 4) {
			 for(int i=0;i<3;i++) {
				 Cell cell =PaintField.theField.get(x, y+i); 
			    	cell.isalive = true;
			        cell.Display(g, x, y+i, Color.green);
			    }
			 Cell cell =PaintField.theField.get(x+1, y+1);	   
			 cell.isalive = true;
		     cell.Display(g, x+1, y+1, Color.green);	
		}
			
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "TBox";
	}


}
