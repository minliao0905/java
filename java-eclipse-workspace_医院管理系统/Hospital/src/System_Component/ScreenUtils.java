package System_Component;

import java.awt.Toolkit;

public class ScreenUtils {

	 /*
    ��ȡ��ǰ��Ļ�Ŀ��
 */
public static int getScreenWidth(){
    return Toolkit.getDefaultToolkit().getScreenSize().width;
}

/*
    ��ȡ��ǰ��Ļ�ĸ߶�
 */

public static int getScreenHeight(){
    return Toolkit.getDefaultToolkit().getScreenSize().height;
}
}
