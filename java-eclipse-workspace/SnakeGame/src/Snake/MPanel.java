package Snake;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

//import  javax.sound.sampled.*;
import java.io.IOException;
import java.io.InputStream;

public class MPanel extends JPanel implements KeyListener,ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4148785518395793767L;
	ImageIcon title;
	ImageIcon body;
	ImageIcon up;
	ImageIcon down;
	ImageIcon left;
	ImageIcon right;
	ImageIcon food;
	
		int len = 3; 
		int score=0;
	int[] snakex = new int[750];
	int[] snakey = new int[750];
	String fx="R";           //����R,L,U,D
	boolean isstart = false;
	boolean isfailed = false;
	int foodx,foody,foodnum=3;
	Random rand = new Random();
	
	Timer timer = new Timer(100, this);   //  ��������ʱ�ӣ�
	 public MPanel() {
		 loadImage();
		 initSnake();   //����ߵļ��㣬ͼ����ʾ
		 this.setFocusable(true);  //��������Ȩ��
		 this.addKeyListener(this);
		 timer.start();        //ʱ�ӿ�ʼ
//		 playBGM();
	 }


	public void paintComponent(Graphics g) {  //�Զ�ִ��
		 super.paintComponent(g);
//		 this.setBackground(Color.white);
		 title.paintIcon(this,g,15,11) ;     //���ʻ��ڻ�����
		 g.fillRect(15, 75, 850, 600);       //���������
		 g.setColor(Color.WHITE);
         g.setFont(new Font("arial",Font.BOLD,20));  
		 g.drawString("len:" + len,750,35);
		 g.drawString("Score:" + score,750,50);
		 if(fx=="R") {
			  right.paintIcon(this,g,snakex[0],snakey[0]);    //�� ��ʼ�����ߵ�ͷ��λ��
		 }else if(fx=="L") {
			  left.paintIcon(this,g,snakex[0],snakey[0]);   
		 }else  if(fx=="U") {
			  up.paintIcon(this,g,snakex[0],snakey[0]);    //�� ��ʼ��
		 }else if(fx=="D") {
			  down.paintIcon(this,g,snakex[0],snakey[0]);   
		 }
	     
		 
		//���δ��ʼ ����ʾ�����Ϸ��ʼ���棻
		 if(isstart==false) {
			     g.setColor(Color.WHITE);
	             g.setFont(new Font("arial",Font.BOLD,40));     //����������ɫ��ʽ�����壬�ֺ�
		         g.drawString("Press Space to Start",200,300);
		
	     }
		 if(isfailed) {
		     g.setColor(Color.red);
             g.setFont(new Font("arial",Font.BOLD,40));     //����������ɫ��ʽ�����壬�ֺ�
	         g.drawString("Failed:Press Space to Start again",100,300);
	
     }
	     for(int i=1;i<len;i++) {
			 body.paintIcon(this, g, snakex[i],snakey[i]);
		 }
		 
		  food.paintIcon(this,g,foodx,foody);
	    
		
}
	 
	 public void initSnake() {
		 len = 3;
		 snakex[0] = 100;
		 snakey[0] = 100;
		 snakex[1] = 75;
		 snakey[1] = 100;
		 snakex[2] = 50;
		 snakey[2] = 100;
		 foodx =25+ 25*rand.nextInt(34);
		 foody =75+ 25*rand.nextInt(24);
		 fx="R";
		score =0;
	 }
	 /****����***** /****����*****/ /****����*****/ /****����*****/ /****����*****/ /****����*****/
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
	   int keyCode =e.getKeyCode();
  	   if(keyCode == KeyEvent.VK_SPACE) {   //�жϿո����
  		   if(isfailed) {
  			   isfailed =false;
  			   initSnake();
  		   }else {
  			   isstart = !isstart;       //�ı�״̬��
  		   }
		repaint();                 //Ĭ�Ϸ����� ���¿�ʼ���滭��
  	   	}
  	   else if(keyCode == KeyEvent.VK_LEFT) {
  		fx="L";
  	}
  	   else if(keyCode == KeyEvent.VK_RIGHT) {
  		fx="R";
  	}
  	   else	if(keyCode == KeyEvent.VK_UP) {
  		fx="U";
  	}
  	   else if(keyCode == KeyEvent.VK_DOWN) {
  		fx="D";
  	}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	 /****����***** /****����*****/ /****����*****/ /****����*****/ /****����*****/ /****����*****/
	 /****�����ƶ�*****//****�����ƶ�*****//****�����ƶ�*****//****�����ƶ�*****//****�����ƶ�*****//****�����ƶ�*****/
	@Override
	public void actionPerformed(ActionEvent e) {
		if(isstart&&!isfailed) {
			for(int i=len-1;i>0;i--) {         //���һ���ڵ��ƶ�
			snakex[i]=snakex[i-1];
			snakey[i]=snakey[i-1];			
		    }
			if(fx=="R") {
				snakex[0] = snakex[0]+25;
				if(snakex[0]>850) snakex[0]= 25;
			}else if(fx=="L") {
				snakex[0] = snakex[0]-25;
				if(snakex[0]<25) snakex[0]= 850;
			}else if(fx=="U") {
				snakey[0] = snakey[0]-25;
				if(snakey[0]<75) snakey[0]= 650;
			}else if(fx=="D") {
				snakey[0] = snakey[0]+25;
				if(snakey[0]>670) snakey[0]= 75;
			}
			
			if(snakex[0]==foodx&&snakey[0]==foody)
			{
				len++;//���鳤��Ϊ750�������ߵ���󳤶�
				score +=10;
				 foodx =25+ 25*rand.nextInt(34);
				 foody =75+ 25*rand.nextInt(24);
			}
			for(int i=1;i<len ;i++) {
				if(snakex[0]==snakex[i]&&snakey[0]==snakey[i])
					isfailed=true;
			}
		repaint();
		}
		
		timer.start();
	}
	private void loadImage() {
	InputStream is;
	try {
		is = getClass().getClassLoader().getResourceAsStream("image/title.jpg");
		title = new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/body.png");
		 body= new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/left.png");
		left = new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/right.png");
		right = new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/up.png");
		up = new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/down.png");
		down = new ImageIcon(ImageIO.read(is));
		is = getClass().getClassLoader().getResourceAsStream("image/food.png");
		food = new ImageIcon(ImageIO.read(is));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}
//	 private void playBGM() {
//	try {
//	Clip bgm= AudioSystem.getClip();
//	InputStream is =this.getClass().getClassLoader().getResourceAsStream("sound/bgm2.mp3");
//    AudioInputStream ais = AudioSystem.getAudioInputStream(is);
//    bgm.open(ais);
//    bgm.start();
//	} catch (LineUnavailableException e) {
//	e.printStackTrace();
//} catch (UnsupportedAudioFileException e) {
//	e.printStackTrace();
//} catch (IOException e) {
//	e.printStackTrace();
//}
//	
//}
}