package write_Box;

public class GameRole {

	private int vit;
	private int atk;
	private int def;
	
	//��ʼ���ڲ�״̬
	public void initState() {
		this.vit = 100;
		this.atk = 100;
		this.def = 100;
	}
	//ս��
	public void fight() {
		this.atk = 0;
		this.def = 0;
		this.vit = 0;
	}
	public RoleStateMemento saveState() {
		return new RoleStateMemento(vit,atk,def);
	}
	//�ָ���ɫ״̬
	public void recovers( RoleStateMemento roleStatememento) {
		//������¼�����д洢��״̬��ֵ����ǰ����ĳ�Ա
		this.vit = roleStatememento.getVit();
		this.atk = roleStatememento.getAtk();
		this.def = roleStatememento.getDef();
		
	}
	//չʾ״̬����
		public void stateDisplay(){
			System.out.println("��ɫ��������" + vit );
			System.out.println("��ɫ��������" + def );
			System.out.println("��ɫ��������" + atk );
			
		}
	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
}
