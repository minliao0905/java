package adapter_object;



//SDCard����TFCard��������
public class TFadapter  implements SDCard{
	//������������
		private TFCard tfCard;
		public TFadapter(TFCard tfCard){
			this.tfCard = tfCard;
		}
		
		@Override
		public String readSD() {
			System.out.println("Adapter read tf card");
			return tfCard.readTF();
		}

		@Override
		public void writeSD(String msg) {
			System.out.println("adapter write tf card");
			tfCard.writeTF(msg);		
		}
			
	
	
}
