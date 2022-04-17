package adapter_class;
//SDCard¹ØÓÚTFCardµÄÊÊÅäÆ÷
public class TFadapter extends TFcardImpl implements SDCard{
 
	
	@Override
	public String readSD() {
		System.out.println("Adapter read tf card");
		return readTF();
	}

	@Override
	public void writeSD(String msg) {
		System.out.println("adapter write tf card");
		writeTF(msg);		
	}
	
	
	
}
