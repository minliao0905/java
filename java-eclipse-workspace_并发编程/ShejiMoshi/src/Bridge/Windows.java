package Bridge;
//��չ�ĳ��󻯽�ɫ
public class Windows extends OpratingSystem {

	public Windows(Videofile videoFile) {
		super(videoFile);
	
	}

	@Override
	public void videoplay(String fileName) {
	
		videoFile.decode(fileName);
	}

}
