package black_Box;
//备忘录管理对象
public class RoleStateCaretaker {
 
	//声明 RoleStateMemento  类型的变量
	private  Memento   memento ;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
}
