package Thread;

public class Demo02Sleep {

	public static void main(String[] args) {
		for(int i=1; i<=60; i++) {
			System.out.println(i);
			//����˯��1����
		}
		try {
			Thread.sleep(3000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("over!");

	}

}
