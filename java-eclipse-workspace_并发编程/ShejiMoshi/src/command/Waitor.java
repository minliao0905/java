package command;

import java.util.ArrayList;
import java.util.List;

public class Waitor {
 
	//���ж���������
	private List<command> commands = new ArrayList<command>();
	
	public void setCommand(command cmd) {
		//������cmd�������list������ ������
		commands.add(cmd);
	}
	//��������� 
	public void orderUp(){
		System.out.println("��Ů����Ա�� �������ˡ���");
		for(command cmd:commands) {
			if(cmd!= null) {
				cmd.execute();
			}
		}
	}
}
