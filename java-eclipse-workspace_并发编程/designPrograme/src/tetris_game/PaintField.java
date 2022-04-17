package tetris_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;



public class PaintField extends JPanel implements ActionListener{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static Filed theField;
	final int BLUE = 1;
	final int GREEN = 2;
	final int RED = 3;
	
	boolean isover = false;   
	boolean isstart = true;
	boolean isfailed = false;
	int f =0;
	
	int move = 0;	
	 int  ROW = 29;  //��
	 int COL = 26;   //��
	 int[][] data = new int[ROW+2][COL+2];	
	private static final int GRID_SIZE = 25;  
	
	Timer timer = new Timer(100,this);
	AbstractBox box =getbox();    //��ǰ�ķ�������
	int pi=0,pj=12;               //Ĭ��λ��;
	
	public PaintField(Filed filed) {
		theField = filed;
		//�ո��ʼ��
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				data[i][j] = 0;
			}
		}
		timer.start();
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		int ROW = theField.getHeight();
		int COL = theField.getWidth();	
	
		for ( int row = 0; row<ROW; row++ ) {
			for ( int col = 0; col<COL; col++ ) {
				Cell cell = theField.get(row, col);
				if ( cell != null ){
					//����������仭������
					switch(data[row][col]) {
					case 0: cell.draw(g, col,row); break;
					case 1: cell.Display(g,col,row,Color.blue); break;
					case 2: cell.Display(g, col,row,Color.green); break;
					case 3: cell.Display(g, col,row,Color.red); break;
					default: break;
					}					
				}
			}
		}
		box.getShape(pj,pi, g,1);
	
	}
	//��������������
	public  AbstractBox getbox() {		
		//��ȡ����
		BoxFactory factory =  BoxFactory.getInstance();  
		Random num = new Random();
		int bn = num.nextInt(3)+1;
		return factory.getShape(bn);
	}
	public void move(int x,int y) {
		//��ȡ�������	
              
     
		//Ȼ���ƶ�
		
	}
	public Dimension getPreferredSize() {
		return new Dimension(theField.getWidth()*GRID_SIZE+1, theField.getHeight()*GRID_SIZE+1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) { 
		if(isstart&&!isfailed) {   //��֤��Ϸ�Ƿ�ʼ����ʧ��  
		    if(isover){
		    	 box = getbox();    	
		    	isover = false;
		     }else { 
		    		 int color =0; 
		    		 if(box instanceof IBox&&(data[pi+3][pj]!=0||pi>ROW-4||pj>COL)) {
		    			 color = 3;f=1;
		    			 for(int i=0;i<3;i++) {
		    			  data[pi+i][pj] = color;  	
		    		  }	
		    		 } 
		    		 else if(box instanceof LBox&&(data[pi+3][pj]!=0||data[pi+3][pj+1]!=0||pi>ROW-4||pj>COL-1)) {
		    			 color = 1;f=1;
		    			 for(int i=0;i<3;i++) {
		    				 data[pi+i][pj] = color;
		    			 }
		    			 data[pi+2][pj+1] = color;
		    		 }
		    		 else if(box instanceof TBox&&(data[pi+2][pj+1]!=0||pi>ROW-2||pj>COL||data[pi+1][pj]!=0||data[pi+1][pj+2]!=0||pi>ROW-3||pj>COL-3)) {
		    			 color =2;f=1;
		    			 for(int i=0;i<3;i++) {
		    				 data[pi][pj+i] = color;
		    		 }
		    			 data[pi+1][pj+1] = color;
		    		}		    	 			
		    			    	
		    	 //�ƶ�����
		    		 if(box instanceof IBox) {
		    			  switch(move) {
	    	 	 case -1:if(pj>0) pj--; move = 0;break; //���Ʋ���
	    		 case 1: if(pj<COL-1)pj++; move = 0;break;//���Ʋ���
	    		 case 2: if(pi<ROW-4&&data[pi+4][pj]==0&&data[pi+3][pj]==0) pi+=2; move =0;break; //�����½�,�½�����;
	    		 default: pi++;break;
		    		 }
		    		 }else if(box instanceof LBox) {
		    			 switch(move) {
			    	 	 case -1:if(pj>0&&data[pi+2][pj-1]==0) pj--; move = 0;break; //���Ʋ���
			    		 case 1: if(pj<COL-1&&data[pi+2][pj+2]==0)pj++; move = 0;break;//���Ʋ���
			    		 case 2: if(pi<ROW-4&&data[pi+4][pj]==0&&data[pi+4][pj+1]==0) pi+=2; move =0;break; //�����½�,�½�����;
			    		 default: pi++;break;
		    		 }
		    		 }else if(box instanceof TBox) {
		    			 switch(move) {
			    	 	 case -1:if(pj>0&&data[pi][pj-1]==0) pj--; move = 0;break; //���Ʋ���
			    		 case 1: if(pj<COL-1&&data[pi][pj+3]==0)pj++; move = 0;break;//���Ʋ���
			    		 case 2: if(pi<ROW-2&&data[pi+1][pj+1]==0) pi+=2; move =0;break; //�����½�,�½�����;
			    		 default: pi++;break;
		    		 }
		    		}
		    		
		    	
		    	 repaint();
		    	 
		    	
		 		  
		 		    //����������һ��//����Ƿ�������	
		 		    while(checkisfull()) {
		 		    	for(int i=ROW;i>0;i--) {
		 		    		for(int j=0;j<COL;j++) {
		 		    			data[i][j] = data[i-1][j];
		 		    		}
		 		    	}
		 		    }
    	        if(f==1) {
    	        	isover = true;
	    			pi = 0; pj = 12;
	    			f=0;
    	        }
    	      
		     }		      
		}
		//ÿ���ƶ����� //ÿ�δ����µ�boxʱ��飬���ߴ���box������//�����Ϸ1�Ƿ�ʧ��		
    	
		    for(int i=0;i<COL;i++) {
				if(data[0][i]!=0||isfailed) {	
					
				 Object[] options = {"����һ��","���ˣ�������Ϸ","ȡ��"};			
					int response = JOptionPane.showOptionDialog(this,"�Ƿ�ѡ�������Ϸ��","��Ϸ����game is over!",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
					if(response == 0) {
						//�ո��ʼ��
						for(int row=0;row<ROW;row++) {
							for(int col=0;col<COL;col++) {
								data[row][col] = 0;
							}
						}
				
						
					}else if(response == 1){
						System.exit(0);          //������Ϸ�رմ��ڡ�
					}
					isfailed = false;
				}
		    }
     timer.start();
	}
	
//����Ƿ�������		
public boolean	checkisfull() {
	boolean check = true;
	    for(int i=0;i<COL;i++) {
			if(data[ROW][i]==0) {
				check = false;
			}				 						 			
		}
	return check;
}
}


