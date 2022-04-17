package System_Component;

public class PathUtils {

	//相对路径创建
    private static final String P_ImagePATH="images/";

    public static String getImagePath(String relativePath){

        return P_ImagePATH+relativePath;
    }

}
