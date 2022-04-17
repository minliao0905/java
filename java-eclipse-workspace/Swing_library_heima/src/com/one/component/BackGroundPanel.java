package com.one.component;
//自定义背景组件-------JPanel
import javax.swing.*;
import java.awt.*;



public class BackGroundPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//声明图片     带参构造函数，传入图片，设置背景图片
    private Image backIcon;
    public BackGroundPanel(Image backIcon){
        this.backIcon = backIcon;
    }

    @Override
    public void paintComponent(Graphics g) {    //图片绘制方法，(0，0，(当前panel的高度和宽度));
        super.paintComponent(g);
        //绘制背景
        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

    }
}
