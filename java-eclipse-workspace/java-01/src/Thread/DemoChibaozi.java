package Thread;

public class DemoChibaozi {

	public static void main(String[] args) {
		Baozi bz1 = new Baozi();
		new BaoziPu(bz1).start();
		new Chihuo(bz1).start();
		Baozi bz2 = new Baozi();
		new BaoziPu(bz2).start();
		new Chihuo(bz2).start();
		Baozi bz3 = new Baozi();
		new BaoziPu(bz3).start();
		new Chihuo(bz3).start();

	}

}
