package Bridge;

public class Avfile implements Videofile{

	@Override
	public void decode(String fileName) {	
		System.out.println("avi��Ƶ�ļ���" + fileName);
	}

}
