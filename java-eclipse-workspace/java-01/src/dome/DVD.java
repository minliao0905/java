package dome;

public class DVD {
	
	//成员变量
		private String title;
		private String artist;
		private int director;
		private int playingTime;
		private boolean gotIt=false;
		private String comment;
		public DVD(String title, String artist, int director, int playingTime, String comment) {
			super();
			this.title = title;
			this.artist = artist;
			this.director = director;
			this.playingTime = playingTime;
			this.comment = comment;
		}

		public static void main(String[] args) {
			// TODO Auto-generated method stub

		}

		public void print() {
			System.out.println("DVD:"+title+":"+director);		
		}
}
