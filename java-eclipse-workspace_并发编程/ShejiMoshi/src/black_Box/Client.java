package black_Box;

public class Client {
  public static void main(String[] args) {
	  GameRole gameRole = new GameRole();
	  gameRole.initState();
	  gameRole.stateDisplay();
	  
	  RoleStateCaretaker   roleStateCaretaker = new  RoleStateCaretaker();
	  roleStateCaretaker.setMemento(gameRole.saveState());
	  
	  gameRole.fight();
	  gameRole.stateDisplay();
	  gameRole.recovers(roleStateCaretaker.getMemento());
	  gameRole.stateDisplay();
  }
}
