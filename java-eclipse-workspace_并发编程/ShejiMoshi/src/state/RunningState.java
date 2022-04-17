package state;

public class RunningState extends Liftstate{

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("电梯正在运行。。。");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.context.setLiftState(Context.STOPING_STATE);
		super.context.stop();
	}

}
