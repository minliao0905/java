package black_Box;

public class GameRole {

	private int vit;
	private int atk;
	private int def;
	
	//初始化内部状态
	public void initState() {
		this.vit = 100;
		this.atk = 100;
		this.def = 100;
	}
	//战斗
	public void fight() {
		this.atk = 0;
		this.def = 0;
		this.vit = 0;
	}
	public Memento saveState() {
		return new RoleStateMemento(vit,atk,def);
	}
	//恢复角色状态
	public void recovers( Memento memento) {
		RoleStateMemento  roleStatememento = (RoleStateMemento) memento;
		//将备忘录对象中存储的状态赋值给当前对象的成员
		this.vit = roleStatememento.getVit();
		this.atk = roleStatememento.getAtk();
		this.def = roleStatememento.getDef();
		
	}
	//展示状态功能
		public void stateDisplay(){
			System.out.println("角色生命力：" + vit );
			System.out.println("角色防御力：" + def );
			System.out.println("角色攻击力：" + atk );
			
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
	
	private class RoleStateMemento implements Memento{

		private int vit;
		private int atk;
		private int def;
		
		public RoleStateMemento() {
				}
		public RoleStateMemento(int vit, int atk, int def) {
			this.vit = vit;
			this.atk = atk;
			this.def = def;
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
}
