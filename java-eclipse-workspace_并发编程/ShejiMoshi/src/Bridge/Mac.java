package Bridge;
//扩展的抽象化角色
public class Mac extends OpratingSystem {

	public Mac(Videofile videoFile) {
		super(videoFile);
	
	}

	@Override
	public void videoplay(String fileName) {
	
		videoFile.decode(fileName);
	}

}
