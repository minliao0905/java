package com.one.component;
//�Զ��屳�����-------JPanel
import javax.swing.*;
import java.awt.*;



public class BackGroundPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//����ͼƬ     ���ι��캯��������ͼƬ�����ñ���ͼƬ
    private Image backIcon;
    public BackGroundPanel(Image backIcon){
        this.backIcon = backIcon;
    }

    @Override
    public void paintComponent(Graphics g) {    //ͼƬ���Ʒ�����(0��0��(��ǰpanel�ĸ߶ȺͿ��));
        super.paintComponent(g);
        //���Ʊ���
        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

    }
}
