package command;

import java.util.ArrayList;
import java.util.List;

public class Waitor {
 
	//持有多个命令对象
	private List<command> commands = new ArrayList<command>();
	
	public void setCommand(command cmd) {
		//将所有cmd对象存入list集合中 有序存放
		commands.add(cmd);
	}
	//发起命令功能 
	public void orderUp(){
		System.out.println("美女服务员： 订单来了。。");
		for(command cmd:commands) {
			if(cmd!= null) {
				cmd.execute();
			}
		}
	}
}
