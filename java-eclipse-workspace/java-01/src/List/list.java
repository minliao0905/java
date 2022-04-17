package List;

import java.awt.List;


public class list {

	public static void main(String[] args) {
//		  Collection cnt = new List();//父类引用指向子类对象
		List lst = new List();
		 lst.add("Mercury");
		 lst.add("Venus");
		 lst.add("Earth");
		 lst.add("JavaSoft");
		 lst.add("Mars");
		 lst.add("Jupiter");
		 lst.add("Saturn");
		 lst.add("Uranus");
		 lst.add("Neptune");
		 lst.add("Pluto");
        lst.add("wodeeempwewe",3);
//        lst.removeAll();

       for(int i=0;i<lst.getItemCount();i++) {
    	   System.out.println(lst.getItem(i));
       }
	}

}
