package Bridge;
//��չ�ĳ��󻯽�ɫ
public class Mac extends OpratingSystem {

	public Mac(Videofile videoFile) {
		super(videoFile);
	
	}

	@Override
	public void videoplay(String fileName) {
	
		videoFile.decode(fileName);
	}

}
