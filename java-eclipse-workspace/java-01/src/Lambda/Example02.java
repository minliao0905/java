package Lambda;

@FunctionalInterface
interface PerSonBuilder{
	Person buildePerson(String name);
}
class Person{
	private String name; 
	
	//构造方法
	public Person(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	//定义函数接口的内部类
	static class Person02{
		private String name; 
		
    public Person02(String name) {
    	this.name = name;
    }
	public String getName02() {
		return name;
	}

//	
	public Person buildePerson() {
		Person personimpl = new Person("xiaoguoimpl");		
      System.out.println("Impl:"+personimpl.getName());
		return personimpl;
	}
}
}

public class Example02 {
	
   public static void  printName(String name,PerSonBuilder personbuilder) {
	   System.out.println(personbuilder.buildePerson(name).getName());
   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//lambda表达式
         printName("xiaoguo",name->new Person(name));
         //构造器
         printName("xiaoguo",Person::new);
         
       Person person02 = new Person("xiaoguo");
        System.out.println(person02.getName());
        
        Person.Person02 person03 = new Person.Person02("xiaoguo03");
        System.out.println(person03.getName02());
        System.out.println(person03.buildePerson().getName());
	}

}
