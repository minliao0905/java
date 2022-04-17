package state;

public class Context {
  //�����Ӧ״̬����ĳ���
	public final static OpeningState OPENING_STATE = new OpeningState();
	public final static ClosingState CLOSING_STATE = new ClosingState();
	public final static RunningState RUNNING_STATE = new RunningState();
	public final static StopingState STOPING_STATE = new StopingState();
	
	//���嵱ǰ����״̬����
	private  Liftstate liftState;
	
	public Liftstate getLiftstate() {
		return liftState;
	}
	
	//���õ�ǰ״̬����
	public void setLiftState(Liftstate liftState) {
		this.liftState = liftState;
		//���õ�ǰ״̬�е�context����
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
