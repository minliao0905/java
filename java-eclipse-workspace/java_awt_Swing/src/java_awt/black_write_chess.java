package java_awt;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Box;

//import javax.swing.Box;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class black_write_chess {
	
private	Frame frame = new Frame("��������Ϸ");

Panel panel=new Panel();

//�ײ���ť���
Button bwhite = new Button("����");
Button  bblack = new Button("����");
Button back = new Button("����");
Button Return = new Button("������Ϸ");
Button Retry = new Button("���¿�ʼ");

//����vector
Vector<point> points = new Vector<point>(256);

 
//�����ĸ�BufferedImage ���󣬷ֱ��¼����ͼ��
	BufferedImage Black;
	BufferedImage White;
	BufferedImage table;
	BufferedImage Selected;
	
	//�������̵Ŀ�͸�
	final int Table_width = 536;
	final int Table_height= 536;
	
	//�����ݺ�������¶��ٸ�����
	final int Board_size =15;
	
	//����ռ�����̵ı���
	final int Rate = Table_width/Board_size;
	
	//���Ӷ���xy�����ƫ����������λ�ã�
	final int X_offset = 5;
	final int Y_offset = 6;
	
	//�����ά���� ,��¼����
	int[][] board = new int[Board_size][Board_size+1];//�������״�����������������
	
	
	//������ɫѡ��������,�������Ƕ�ά����board�е�����
	int  select_X= -1;
	int  select_Y= -1;
	
	//������������ǰ�������ɫ��
    int board_type = 0;
	//�Զ����ࡣ�̳�Canvas
	private class ChessBoard extends Canvas{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//��дpaint������
		@Override	
		
		public void paint(Graphics g) {
			//��ͼ
			
			//��������
					g.drawImage(table,0,0,null);
			

			//����ѡ���
			if(select_X>0&&select_Y>0) {
				g.drawImage(Selected, select_X*Rate+X_offset, select_Y*Rate+Y_offset, null);
			}
			//��������
			//˫��ѭ������������;
			for(int i = 0;i<Board_size;i++) {
				for(int j=0;j<Board_size;j++) {
					//���ƺ��壻
					if(board[i][j]==-1) {
						g.drawImage(Black, i*Rate+X_offset, j*Rate+Y_offset,null);
						point p = new point(i,j);   //��������
						points.add(p);
					}
					//���ư��壻
					if(board[i][j]==1) {
						g.drawImage(White, i*Rate+X_offset, j*Rate+Y_offset,null);
						point p = new point(i,j);
						points.add(p);
					}
				}
			}
		}
	}
	
	ChessBoard chessboard = new ChessBoard();
	
	
   //���������ײ����,��ť��ӵ�frame��壻
	Button[] buttons = new Button[5]; 
    public void ButtonAll() {	

	buttons[0] = bwhite;
	buttons[1] = bblack;
	buttons[2] = back;
	buttons[3] = Return ;
	buttons[4] = Retry; 
	Box buttBox = Box.createHorizontalBox();
	    for(int i=0;i<buttons.length;i++) {
	         buttBox.add(buttons[i]);
	    }

   frame.add(buttBox,BorderLayout.SOUTH);  //��ӵ������Ϸ�
   
  
    }
    
    
    //��ť��ɫ
    public void RefreshButtonColor(int index) {
    	if(index!=-1) {
    		buttons[index].setBackground(Color.gray);     //����İ�ť��Ϊ��ɫ	
    		for(int i=0;i<buttons.length;i++) {
	       if(i!=index) {
	    	   buttons[i].setBackground(Color.white);   //������Ϊ��ɫ
	        }
      	  }
    	}
       else {
    		for(int i=0;i<buttons.length;i++) {
    		buttons[i].setBackground(Color.white);   //������Ϊ��ɫ
    		}
	    }	
    }
  
    
    
	//����:��ť�����¼���
	public void init() {
		
	  ButtonAll();	 
	  
	  
	//��ť����,�������ťʱ��ɫ��Ϊ��ɫ
	for(int i=0;i<buttons.length;i++) {
		final int x = i;
		buttons[i].addActionListener(e->{			
			RefreshButtonColor(x);
		});
	}
	//��ɫ��ť
	bwhite.addActionListener(e->{
	
		board_type=1;        	 //�޸ĵ�ǰҪ�µ����ӣ���ɫ
		RefreshButtonColor(0);	 //����İ�ť��ɫ�ı�
	});	
	//��ɫ��ť
	bblack.addActionListener(e->{
		board_type = -1;         
		RefreshButtonColor(1);
	});
	//���水ť
	Retry.addActionListener(e->{
		for(int i = 0;i<Board_size;i++) {
			for(int j=0;j<Board_size;j++) {
				board[i][j] = 0;	
			}
		}
		chessboard.repaint();
	});
	//������ť;
	Return.addActionListener(e->{
		
		System.exit(0);
	});
	//���ذ�ť
	back.addActionListener(e->{
		
		if(!points.isEmpty()) {
		int x = points.lastElement().getlastX();
		int y = points.lastElement().getlastY();
//		System.out.println(points.lastElement().toString());   // �������
		points.remove(points.size()-1);//��ȥ���һ��
		board[x][y]=0;
		chessboard.repaint();
		}
		
		
	});
	//��װ����
	try {
		table = ImageIO.read(new File("img/board.jpg"));
		Black = ImageIO.read(new File("img/black.gif"));
		White = ImageIO.read(new File("img/white.gif"));
		Selected = ImageIO.read(new File("img/selected.gif"));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	//��������ƶ�
	chessboard.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
		select_X = 	(e.getX()-X_offset)/Rate;
		select_Y =  (e.getY()-Y_offset)/Rate;
			
//		chessboard.repaint();
		}
	});
	//������걻���
	chessboard.addMouseListener(new MouseAdapter() {
		//����걻���
		@Override
		public void mouseClicked(MouseEvent e) {
			int xpos = (e.getX()-X_offset)/Rate;
			int ypos = (e.getY()-Y_offset)/Rate;
			
			board[xpos][ypos] = board_type;
			board_type = -board_type;     //�ڰ��尴ť����
			RefreshButtonColor(-1);         //���еİ�ť�ָ���ɫ
			chessboard.repaint();
		}
		//�����Զ�������壻��Ҫ����select���ꣻ
		@Override
		public  void mouseExited(MouseEvent e) {
			select_X = -1;
			select_Y = -1;
			chessboard.repaint();
		}
	});
	
	chessboard.setPreferredSize(new Dimension(Table_width,Table_height));
	frame.add(chessboard);
	
	 frame.setVisible(true);
	 frame.setBounds(100,100,536,600);
	}

	
	public static void main(String[] args) {
	    
		new black_write_chess().init();

	}

}
