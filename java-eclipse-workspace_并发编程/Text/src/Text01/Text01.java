package Text01;



public class Text01 {
    public static void main(String[] args) throws InterruptedException {
    	for(int i =0 ;i< 3;i++) {
    		new People().start();
    	}
    	Thread.sleep(1);
    	for(Integer id:MailBoxes.getIds()) {
    		new Postman(id,"内容"+id).start();
    	}
    }
}

class People extends Thread{
	@Override
	public void run() {
		//收信
		GuardeObject guardeObject = MailBoxes.createGuardeObject();
		System.out.println(Thread.currentThread().getName()+"等待收信 id: " + guardeObject.getId());
		Object mail = guardeObject.get(5000);  //收信
		System.out.println(Thread.currentThread().getName()+"收到信 id: "+ guardeObject.getId()+" 内容: "+mail);
	}
}

class Postman extends Thread{
	    private int id;
		private String  mail;
		//邮递员需获取邮件id  
		public Postman(int id, String mail) {
			this.id = id;
			this.mail = mail;
		}
		
		
			
	@Override
	public void run() {
		GuardeObject guardeObject = MailBoxes.getguardeObject(id);  //将Map的GuardeObject移除,并且返回该对象
		System.out.println(Thread.currentThread().getName()+"送短信 id:" + guardeObject.getId());
		guardeObject.complete(mail);   //mail-->response People的response接受短信，停止等待。			
	}
}