package mssaolei;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.BorderFactory;
//import javax.swing.ImageIcon;    //Icon图标引用
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Saolei  implements ActionListener{
	JFrame frame = new JFrame();

//	ImageIcon  bannerIcon = new ImageIcon("true.jpg");
//	ImageIcon  guessIcon = new ImageIcon("icon.png");
//	ImageIcon  bombIcon = new ImageIcon("icon.png");
	JButton  bannerBtn = new JButton("扫雷游戏");
	
	//数据结构start
	int ROW = 20;
	int COL = 20;
	int [][] data = new int[ROW][COL];
	JButton[][] btns = new JButton[ROW][COL];
	int LEICOUNT = 10;   //雷个数
	int LEICODE = -1;
	int unopened = ROW*COL;
	int opened = 0;
	int timeSecond =0;
	//三个 jlabel 状态栏 已开未开，用时
	JLabel label1= new JLabel("待开:"+unopened);
	JLabel label2= new JLabel("已开:"+opened);
	JLabel label3= new JLabel("用时:"+timeSecond+"s");
	Timer timer = new Timer(1000, this); //定义时间为一秒
	//数据结构end
    //创建扫雷窗口界面  
	public Saolei() {		
			frame.setSize(600,700);
			frame.setResizable(false);//设置窗口尺寸不能变化
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLayout(new BorderLayout());//分块
			setHeader();//设置界面初始化
			addlei();   //添加雷
			setButtons();//添加按钮
			timer.start();   //启动时钟；
			frame.setVisible(true);
		}
	
	private void addlei() {
		Random rand = new Random();
		for(int i=0;i<LEICOUNT;) {
			int r = rand.nextInt(ROW);
			int c= rand.nextInt(COL);
			if(data[r][c]!=LEICODE) {
				data[r][c] = LEICODE;
				i++;
//				System.out.println(r+"  "+c+" "+data[r][c]);
			}
		}
		
		
		//计算周边雷的数量
		  for(int i=0;i<ROW;i++) {
			  for(int j=0;j<COL;j++) {
				  if(data[i][j]!=LEICODE) {
					   int  c=0;
					   if(i>0&&j>0&&data[i-1][j-1]==LEICODE) c++;
					   if(i>0&&data[i-1][j]==LEICODE) c++;
					   if(i>0&&j<19&&data[i-1][j+1]==LEICODE) c++;
					   if(j>0&&data[i][j-1]==LEICODE) c++;
					   if(j<19&&data[i][j+1]==LEICODE) c++;
					   if(i<19&&j>0&&data[i+1][j-1]==LEICODE) c++;
					   if(i<19&&data[i+1][j]==LEICODE) c++;
					   if(i<19&&j<19&&data[i+1][j+1]==LEICODE) c++;
					   data[i][j]=c;
				  }
				
				 
			  }
		  }
		
	}

	private void setButtons() {
	  Container con = new Container();//container容器
	  con.setLayout(new GridLayout(ROW,COL));//创建方格
	  
	  for(int i=0;i<ROW;i++) {
		  for(int j=0;j<COL;j++) {
			  JButton btn = new JButton();
			  btn.setOpaque(true);
			  btn.setBackground(new Color(200,183,113));  //设置扫雷背景颜色
			  btn.addActionListener(this);  //Btn添加按钮监听事件
			  btn.setMargin(new Insets(0,0,0,0));  //button数字显示不出来，加上该语句即可显示
			  con.add(btn);
			  btns[i][j] = btn;
		  }
	  }
	  frame.add(con,BorderLayout.CENTER);			//中间位置
	  
	}
//设置开头显示
	private void setHeader() {
		//设置画布 JPanel
		JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints c1 = new GridBagConstraints(0,0,3,1,1.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
		panel.add(bannerBtn,c1);
		
		bannerBtn.addActionListener(this);
		label1.setOpaque(false);    //设置不透明,背景色，
		label1.setBackground(Color.white);   
		label1.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		label2.setOpaque(true);
		label2.setBackground(Color.white);
		label2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		label3.setOpaque(true);
		label3.setBackground(Color.white);
		label3.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		bannerBtn.setOpaque(true);
		bannerBtn.setBackground(Color.white);
		bannerBtn.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
		
		GridBagConstraints c2 = new GridBagConstraints(0,1,1,1,1.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
		panel.add(label1,c2);
		GridBagConstraints c3 = new GridBagConstraints(1,1,1,1,1.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
		panel.add(label2,c3);
		GridBagConstraints c4 = new GridBagConstraints(2,1,1,1,1.0,1.0,GridBagConstraints.CENTER,GridBagConstraints.BOTH,new Insets(0,0,0,0),0,0);
		panel.add(label3,c4);
		
		frame.add(panel,BorderLayout.NORTH);
		
	}
	public static void main(String[] args) {
		
		new Saolei();

	}

	//btn 的监听事件
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof Timer) {
			timeSecond++;
			label3.setText("用时:"+timeSecond+"s");
			timer.start();
			return ;
		}
		JButton btn = (JButton)e.getSource();  //强制类型转换
       if(btn.equals(bannerBtn)) {
    	   restart();
    	   return; 
       }
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if(btn.equals(btns[i][j])) {
					if(data[i][j]==LEICODE) {
						lose();
					 
					}else {
						openCell(i,j,0);
						checkWin();
					}
					
					return ;
				}
			}
		}
		
	}
	private void restart() {
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++){
				data[i][j]=0;
				btns[i][j].setBackground(new Color(200,183,113));
				btns[i][j].setEnabled(true);
				btns[i][j].setText("");
			}
		}
		unopened = ROW*COL;
		opened = 0;
		timeSecond = 0;
		label1.setText("待开:"+ unopened);
		label2.setText("已开:"+ opened);
		label3.setText("用时:" + timeSecond + "s");
		addlei();
		bannerBtn.setText("扫雷游戏");
		timer.start();
	}

	//判断胜利！！！
	
	private void checkWin() {
		
		 int count=0;
			for(int i=0;i<ROW;i++) {
				for(int j=0;j<COL;j++) {
					if(btns[i][j].isEnabled()) {
						count++;
						
					}
				}
			}
			unopened = count;
			opened =  ROW*COL-count;
			
			label1.setText("待开:"+ unopened);
			label2.setText("已开:"+ opened);
			if(count==LEICOUNT) {
				timer.stop(); 
				bannerBtn.setText("游戏胜利！！！");
				for(int i=0;i<ROW;i++) {
					for(int j=0;j<COL;j++) {
						if(btns[i][j].isEnabled()) {
							  btns[i][j].setBackground(new Color(100,183,0));
                   
						}
					}
				}
				bannerBtn.setText("Banner：restart！");
				JOptionPane.showMessageDialog(frame, "恭喜你！游戏胜利啦！\n 可以点击上面的Banner重新开始！","游戏结束！",JOptionPane.PLAIN_MESSAGE);
			}
			
		
	}

	//踩雷成功，游戏结束！
	private void lose() {
		timer.stop();
		 bannerBtn.setText("很遗憾，踩雷成功，游戏结束！！！");
		for(int i=0;i<ROW;i++) {
			for(int j=0;j<COL;j++) {
				if(btns[i][j].isEnabled()) {
					JButton btn = btns[i][j];
					if(data[i][j]==LEICODE) {
//					btns[i][j].setEnabled(false);	btns[i][j].setIcon(bombIcon); btns[i][j].setDisabledIcon(bombIcon);
				   
						btn.setBackground(Color.red);	 //置为红色
						btn.setText(data[i][j]+"");
					}
					else {
						btn.setIcon(null);
						btn.setEnabled(false);   //btn已经打开不可点击
						btn.setOpaque(true);
		
					}
				}
			}
		}
		bannerBtn.setText("Banner：restart！");
		JOptionPane.showMessageDialog(frame, "很遗憾，暴雷成功，游戏结束！！！\n 可以点击上面的Banner重新开始！","游戏结束！",JOptionPane.PLAIN_MESSAGE);
		
	}

	//空白级联打开
	private void openCell(int i,int j,int Blankcount ){
		JButton btn=btns[i][j];
		if(!btn.isEnabled()) return ;
		if(Blankcount==10)   //部分打开，设置数字限制
			return;
		btn.setIcon(null);
		btn.setEnabled(false);
		btn.setOpaque(true);
		Blankcount++;
		btn.setBackground(Color.GREEN);
		btn.setText(data[i][j]+"");
		if(data[i][j]==0) {
			 if(i>0&&j>0&&data[i-1][j-1]==0) openCell(i-1,j-1,Blankcount);
			   if(i>0&&data[i-1][j]==0) openCell(i-1,j,Blankcount);
			   if(i>0&&j<19&&data[i-1][j+1]==0) openCell(i-1,j+1,Blankcount);
			   if(j>0&&data[i][j-1]==0) openCell(i,j-1,Blankcount);
			   if(j<19&&data[i][j+1]==0) openCell(i,j+1,Blankcount);
			   if(i<19&&j>0&&data[i+1][j-1]==0) openCell(i+1,j-1,Blankcount);
			   if(i<19&&data[i+1][j]==0) openCell(i+1,j,Blankcount);
			   if(i<19&&j<19&&data[i+1][j+1]==0) openCell(i+1,j+1,Blankcount);
		}
		
	}

}
