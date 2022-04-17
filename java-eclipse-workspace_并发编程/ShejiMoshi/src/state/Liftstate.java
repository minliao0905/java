package state;
//电梯运行状态
public abstract class Liftstate {

//声明环境角色类变量
	protected Context context;

	public void setContext(Context context) {
	
		this.context = context;
	}
	//电梯操作
	public abstract void open();
	public abstract void close();
	public abstract void run();
	public abstract void stop();
}
