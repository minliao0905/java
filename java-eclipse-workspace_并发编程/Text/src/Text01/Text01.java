package Text01;



public class Text01 {
    public static void main(String[] args) throws InterruptedException {
    	for(int i =0 ;i< 3;i++) {
    		new People().start();
    	}
    	Thread.sleep(1);
    	for(Integer id:MailBoxes.getIds()) {
    		new Postman(id,"����"+id).start();
    	}
    }
}

class People extends Thread{
	@Override
	public void run() {
		//����
		GuardeObject guardeObject = MailBoxes.createGuardeObject();
		System.out.println(Thread.currentThread().getName()+"�ȴ����� id: " + guardeObject.getId());
		Object mail = guardeObject.get(5000);  //����
		System.out.println(Thread.currentThread().getName()+"�յ��� id: "+ guardeObject.getId()+" ����: "+mail);
	}
}

class Postman extends Thread{
	    private int id;
		private String  mail;
		//�ʵ�Ա���ȡ�ʼ�id  
		public Postman(int id, String mail) {
			this.id = id;
			this.mail = mail;
		}
		
		
			
	@Override
	public void run() {
		GuardeObject guardeObject = MailBoxes.getguardeObject(id);  //��Map��GuardeObject�Ƴ�,���ҷ��ظö���
		System.out.println(Thread.currentThread().getName()+"�Ͷ��� id:" + guardeObject.getId());
		guardeObject.complete(mail);   //mail-->response People��response���ܶ��ţ�ֹͣ�ȴ���			
	}
}