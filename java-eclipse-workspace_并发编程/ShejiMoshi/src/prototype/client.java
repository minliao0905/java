package prototype;

public class client {
		public static void main(String[] args) throws CloneNotSupportedException {
			//����һ��ԭ�������
			Realizetype realizetype = new Realizetype();
			
			//�������е�clone�������ж���Ŀ�¡
			Realizetype clone = realizetype.clone();
			//�Ƚϵ�ֵַ�������Ϊͬһ������false��
			System.out.println("ԭ�Ͷ���Ϳ�¡�����Ķ����Ƿ���ͬһ������"+(realizetype == clone)) ;
			 
		}
}
