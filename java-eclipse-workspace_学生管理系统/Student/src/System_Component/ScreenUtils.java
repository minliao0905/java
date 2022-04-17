package System_Component;

import java.awt.Toolkit;

public class ScreenUtils {

	 /*
    获取当前屏幕的宽度
 */
public static int getScreenWidth(){
    return Toolkit.getDefaultToolkit().getScreenSize().width;
}

/*
    获取当前屏幕的高度
 */

public static int getScreenHeight(){
    return Toolkit.getDefaultToolkit().getScreenSize().height;
}
}
