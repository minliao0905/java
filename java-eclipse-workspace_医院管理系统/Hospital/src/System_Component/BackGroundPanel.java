package System_Component;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackGroundPanel extends JPanel{
	
	  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image backIcon;
	    public BackGroundPanel(Image backIcon){
	        this.backIcon = backIcon;
	    }
/*���� 1   public abstract boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer); 
  ����ָ��ͼ��ͼ�����꣬��ǰJPanel�ĸߺͿ�observer       
        
  paintComponent() ���Ƹ������Ϊϵͳ�Զ����õ�   ��������캯���У��Զ�������ʾ���      
 */
	    @Override
	    public void paintComponent(Graphics g) {    //ͼƬ���Ʒ�����(0��0��(��ǰpanel�ĸ߶ȺͿ��));
	        super.paintComponent(g);             
	        
	        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

	    }

}
