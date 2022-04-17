package state;

public class Context {
  //定义对应状态对象的常量
	public final static OpeningState OPENING_STATE = new OpeningState();
	public final static ClosingState CLOSING_STATE = new ClosingState();
	public final static RunningState RUNNING_STATE = new RunningState();
	public final static StopingState STOPING_STATE = new StopingState();
	
	//定义当前电梯状态变量
	private  Liftstate liftState;
	
	public Liftstate getLiftstate() {
		return liftState;
	}
	
	//设置当前状态对象
	public void setLiftState(Liftstate liftState) {
		this.liftState = liftState;
		//设置当前状态中的context对象
		this.liftState.setContext(this);
		
	}
	
	public void open() {
		this.liftState.open();
	}
	
	public void stop() {
		this.liftState.stop();
	}
	public void run() {
		this.liftState.run();
	}
	public void close() {
		this.liftState.close();
	}
}
