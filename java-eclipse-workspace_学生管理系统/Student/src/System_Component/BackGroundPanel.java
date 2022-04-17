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
/*方法 1   public abstract boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer); 
  绘制指定图像，图像坐标，当前JPanel的高和宽，observer       
        
  paintComponent() 绘制该组件，为系统自动调用的   在组件构造函数中，自动调用显示组件      
 */
	    @Override
	    public void paintComponent(Graphics g) {    //图片绘制方法，(0，0，(当前panel的高度和宽度));
	        super.paintComponent(g);             
	        
	        g.drawImage(backIcon,0,0,this.getWidth(),this.getHeight(),null);

	    }

}
