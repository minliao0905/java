package state;

public class ClosingState  extends Liftstate{

	public void open() {
		super.context.setLiftState(Context.OPENING_STATE);
		super.context.open();
		
	}


	public void close() {
		System.out.println("µÁÃ›πÿ±’¡À");
	}

	public void run() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.RUNNING_STATE);
		super.context.run();
	}

	public void stop() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.STOPING_STATE);
		super.context.stop();
	}


}	
