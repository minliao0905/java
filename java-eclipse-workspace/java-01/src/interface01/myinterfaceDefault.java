package interface01;
//��java8��ʼ���ӿ���������Ĭ�Ϸ�����
public interface myinterfaceDefault {
//�ӿڵ��е�Ĭ�Ϸ��������Խ���ӿ����������⣻
 public abstract void methodAbs();
// ����ӵķ��� �ĳ�Ĭ�Ϸ���
 public default void methodDefault() {
	 System.out.println("��������ӵ�Ĭ�Ϸ�����");
 }
}

