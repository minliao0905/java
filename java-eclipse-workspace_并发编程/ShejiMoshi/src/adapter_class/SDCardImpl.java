package adapter_class;

public class SDCardImpl implements SDCard {

	@Override
	public String readSD() {
		String msg = "SDCard read msg :hello word SDcard";
		
		return msg;
	}

	@Override
	public void writeSD(String msg) {
		System.out.println("SDcard write msg :" + msg);
		
	}

}
