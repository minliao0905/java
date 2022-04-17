package state;

public class StopingState  extends Liftstate{

	public void open() {
		super.context.setLiftState(Context.OPENING_STATE);
		super.context.open();
		
	}


	public void close() {
		super.context.setLiftState(Context.CLOSING_STATE);
		super.context.close();
	}

	public void run() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.RUNNING_STATE);
		super.context.run();
	}

	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("µÁÃ›Õ£÷π¡À");
	}

}