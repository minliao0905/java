package adapter_object;



//SDCard关于TFCard的适配器
public class TFadapter  implements SDCard{
	//声明适配者类
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
