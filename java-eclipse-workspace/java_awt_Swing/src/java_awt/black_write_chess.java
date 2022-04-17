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
	
private	Frame frame = new Frame("五子棋游戏");

Panel panel=new Panel();

//底部按钮组件
Button bwhite = new Button("白棋");
Button  bblack = new Button("黑棋");
Button back = new Button("撤回");
Button Return = new Button("结束游戏");
Button Retry = new Button("重新开始");

//定义vector
Vector<point> points = new Vector<point>(256);

 
//定义四个BufferedImage 对象，分别记录四张图像
	BufferedImage Black;
	BufferedImage White;
	BufferedImage table;
	BufferedImage Selected;
	
	//声明棋盘的宽和高
	final int Table_width = 536;
	final int Table_height= 536;
	
	//棋盘纵横向可以下多少个棋子
	final int Board_size =15;
	
	//棋子占用棋盘的比率
	final int Rate = Table_width/Board_size;
	
	//棋子对于xy方向的偏移量，鼠标的位置；
	final int X_offset = 5;
	final int Y_offset = 6;
	
	//定义二维数组 ,记录棋子
	int[][] board = new int[Board_size][Board_size+1];//出现误点状况，导致数组溢出；
	
	
	//声明红色选择框的坐标,该坐标是二维数组board中的索引
	int  select_X= -1;
	int  select_Y= -1;
	
	//声明变量，当前下棋的颜色；
    int board_type = 0;
	//自定义类。继承Canvas
	private class ChessBoard extends Canvas{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		//重写paint方法；
		@Override	
		
		public void paint(Graphics g) {
			//绘图
			
			//绘制棋盘
					g.drawImage(table,0,0,null);
			

			//绘制选择框
			if(select_X>0&&select_Y>0) {
				g.drawImage(Selected, select_X*Rate+X_offset, select_Y*Rate+Y_offset, null);
			}
			//绘制棋子
			//双重循环，根据数组;
			for(int i = 0;i<Board_size;i++) {
				for(int j=0;j<Board_size;j++) {
					//绘制黑棋；
					if(board[i][j]==-1) {
						g.drawImage(Black, i*Rate+X_offset, j*Rate+Y_offset,null);
						point p = new point(i,j);   //存入容器
						points.add(p);
					}
					//绘制白棋；
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
	
	
   //声明变量底部组件,按钮添加到frame面板；
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

   frame.add(buttBox,BorderLayout.SOUTH);  //添加到面板的南方
   
  
    }
    
    
    //按钮颜色
    public void RefreshButtonColor(int index) {
    	if(index!=-1) {
    		buttons[index].setBackground(Color.gray);     //点击的按钮置为灰色	
    		for(int i=0;i<buttons.length;i++) {
	       if(i!=index) {
	    	   buttons[i].setBackground(Color.white);   //其他置为白色
	        }
      	  }
    	}
       else {
    		for(int i=0;i<buttons.length;i++) {
    		buttons[i].setBackground(Color.white);   //其他置为白色
    		}
	    }	
    }
  
    
    
	//函数:按钮监听事件，
	public void init() {
		
	  ButtonAll();	 
	  
	  
	//按钮监听,当点击按钮时颜色变为灰色
	for(int i=0;i<buttons.length;i++) {
		final int x = i;
		buttons[i].addActionListener(e->{			
			RefreshButtonColor(x);
		});
	}
	//白色按钮
	bwhite.addActionListener(e->{
	
		board_type=1;        	 //修改当前要下的棋子，白色
		RefreshButtonColor(0);	 //点击的按钮颜色改变
	});	
	//黑色按钮
	bblack.addActionListener(e->{
		board_type = -1;         
		RefreshButtonColor(1);
	});
	//重玩按钮
	Retry.addActionListener(e->{
		for(int i = 0;i<Board_size;i++) {
			for(int j=0;j<Board_size;j++) {
				board[i][j] = 0;	
			}
		}
		chessboard.repaint();
	});
	//结束按钮;
	Return.addActionListener(e->{
		
		System.exit(0);
	});
	//撤回按钮
	back.addActionListener(e->{
		
		if(!points.isEmpty()) {
		int x = points.lastElement().getlastX();
		int y = points.lastElement().getlastY();
//		System.out.println(points.lastElement().toString());   // 检验输出
		points.remove(points.size()-1);//除去最后一个
		board[x][y]=0;
		chessboard.repaint();
		}
		
		
	});
	//组装棋盘
	try {
		table = ImageIO.read(new File("img/board.jpg"));
		Black = ImageIO.read(new File("img/black.gif"));
		White = ImageIO.read(new File("img/white.gif"));
		Selected = ImageIO.read(new File("img/selected.gif"));
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	
	//处理鼠标移动
	chessboard.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseMoved(MouseEvent e) {
		select_X = 	(e.getX()-X_offset)/Rate;
		select_Y =  (e.getY()-Y_offset)/Rate;
			
//		chessboard.repaint();
		}
	});
	//处理鼠标被点击
	chessboard.addMouseListener(new MouseAdapter() {
		//当鼠标被点击
		@Override
		public void mouseClicked(MouseEvent e) {
			int xpos = (e.getX()-X_offset)/Rate;
			int ypos = (e.getY()-Y_offset)/Rate;
			
			board[xpos][ypos] = board_type;
			board_type = -board_type;     //黑白棋按钮交换
			RefreshButtonColor(-1);         //所有的按钮恢复白色
			chessboard.repaint();
		}
		//当鼠标远离操作面板；需要重置select坐标；
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
