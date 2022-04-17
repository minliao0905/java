package combination;

public abstract class MenuComponent {
     //�˵����������
	protected String name;
	protected int level;
	//����Ӳ˵�
	public void add(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	//�Ƴ��Ӳ˵�
	public void remove(MenuComponent menuComponent) {
		throw new UnsupportedOperationException();
	}
	//��ȡָ�����Ӳ˵�
	public MenuComponent getChild(int index) {
		throw new UnsupportedOperationException();
	}
	//��ȡ�˵����߲˵��������
	public String getName() {
		return name;
	}
	//��ӡ�˵����Ƶķ���
	public abstract void  print();
}
