package Bridge;
//����Ĳ���ϵͳ�࣬ ������windows mac
public abstract class OpratingSystem {
	protected Videofile videoFile;

	public OpratingSystem(Videofile videoFile) {
	
		this.videoFile = videoFile;
	}
	//������Ƶ
	public abstract  void videoplay(String fileName);
	
}
