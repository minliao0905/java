package Bridge;
//抽象的操作系统类， 将包含windows mac
public abstract class OpratingSystem {
	protected Videofile videoFile;

	public OpratingSystem(Videofile videoFile) {
	
		this.videoFile = videoFile;
	}
	//播放视频
	public abstract  void videoplay(String fileName);
	
}
