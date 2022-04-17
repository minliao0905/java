package state;

public class OpeningState extends Liftstate{

	@Override
	public void open() {
		System.out.println("µçÌÝ¿ªÆô¡£¡£¡£");
		
	}

	@Override
	public void close() {
		super.context.setLiftState(Context.CLOSING_STATE);
		super.context.close();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
