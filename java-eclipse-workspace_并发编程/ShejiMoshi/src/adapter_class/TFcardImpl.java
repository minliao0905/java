package adapter_class;

public class TFcardImpl implements TFCard{

	@Override
	public String readTF() {
		String msg = "TFCard read msg :hello word TFcard";
		
		return msg;
	}

	@Override
	public void writeTF(String msg) {
		System.out.println("TFcard write msg :" + msg);
		
	}

	
}
