package dome;

public class CD extends Item{    // database管理item,不与cd和dvd联系 item类 cd和dvd都是item的子类
	//成员变量
	private String title;
	private String artist;
	private int numofTracks;
	private int playingTime;
	private boolean gotIt=false;
	private String comment;
	public CD(String title, String artist, int numofTracks, int playingTime, String comment) {
		super();
		this.title = title;
		this.artist = artist;
		this.numofTracks = numofTracks;
		this.playingTime = playingTime;
		this.comment = comment;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void print() {
		System.out.println("CD:"+title+":"+artist);
	}

}
