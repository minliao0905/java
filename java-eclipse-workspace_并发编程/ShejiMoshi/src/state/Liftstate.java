package state;
//��������״̬
public abstract class Liftstate {

//����������ɫ�����
	protected Context context;

	public void setContext(Context context) {
	
		this.context = context;
	}
	//���ݲ���
	public abstract void open();
	public abstract void close();
	public abstract void run();
	public abstract void stop();
}
