package System_Component;

public class PathUtils {

	//���·������
    private static final String P_ImagePATH="images/";

    public static String getImagePath(String relativePath){

        return P_ImagePATH+relativePath;
    }

}
