package educode;
//关：泛类型JDBC封装
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class educode02 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws SQLException,InvocationTargetException {
//插入删除		
		Object ob = new News(4," 123456","123");    //object是创建News对象
		insert(ob);
//      delete(ob);
//遍历显示
		@SuppressWarnings("rawtypes")
		Class  clazz = null;
		try {
			  clazz = Class.forName("educode.News");     //获得News对象
		}catch(Exception e) {
			e.printStackTrace();
		}
     
		List<News> list = new ArrayList<News>();
		list = selectAll(clazz);
		for(News i :list) {
			System.out.println(i);
		}
//
//选择打印；	
//		Class  clazz = null;
//		try {
//			  clazz = Class.forName("educode.News");     //获得News对象
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		Object ob1 = new News();
//		ob1 = selectById(clazz,1);
//		System.out.println(ob1);

	}
	//获取数据库连接
	private static Connection getConnection() {	
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	
		try {
			String url = "jdbc:mysql://localhost:3306/hr?useSSL=false";
			String username = "root";
			String password = "123456";
		    conn = DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
     * 类名对应表，属性对应字段
     * @param obj　　传入的对象
     * @return
     */
    public static void insert(Object obj) {
    	Connection conn = getConnection();  //连接数据库
    	PreparedStatement ps = null;        
    	/********** Begin **********/
    	  Class<?> c = obj.getClass();//获取obj的Class
          StringBuffer sb1 = new StringBuffer("insert "+ c.getSimpleName() +" ( ");         //利用StringBuffer进行修改SQL语句的构造
          StringBuffer sb2 = new StringBuffer(" values(");  
          Field[] field = c.getDeclaredFields();
          for(int i = 0; i < field.length; i++){           //遍历属性构造SQL语句
            if(i != field.length-1) {
                sb1.append(field[i].getName()).append(",");
                sb2.append("?,");
            }else {
                sb1.append(field[i].getName()).append(")");
                sb2.append("?);");
            }
        }
        String sql = sb1.append(sb2).toString();   //拼接两个语句并且toString();
      
        try {
              ps = conn.prepareStatement(sql);
            for(int i = 0; i < field.length; i++) {    
                field[i].setAccessible(true);                    //设置属性的可访问性，可以访问私有属性
                try {                                            //通过Field的get(Object)方法获取Object对象的属性值
                    ps.setObject(i+1, field[i].get(obj));        //对预编译的SQL语句中的？进行赋值
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ps.execute();        //执行SQL

        }       
        /********** End **********/
        
        catch (SQLException e) {
            e.printStackTrace();
        }finally {    
            close(null,ps,conn);
        }
    }
    
    /**
     * 通过对象的Class获取对应表中的所有记录
     * @param c
     * @return
     */
    @SuppressWarnings("deprecation")
	public static <T> List<T> selectAll(Class<T> c) {
    	Connection conn = getConnection();
    	List<T> list = new ArrayList<T>();          
    	PreparedStatement ps = null;
    	ResultSet rs = null;
    	/********** Begin **********/
        String sql = "select * from " + c.getSimpleName()+";";  //通过反射获取类名对应表名构造SQL语句
        Field[] field = c.getDeclaredFields();                   //通过反射获取所有属性

        try {
            
            ps = conn.prepareStatement(sql); 
            rs = ps.executeQuery();
            while(rs.next()){
                T obj = c.newInstance();       //创建对象   class c = Class.forName(“Example”);   factory = (ExampleInterface)c.newInstance();  
                for(int i=0;i<field.length;i++){
                    //设置访问权限；
                    field[i].setAccessible(true);
                    field[i].set(obj,rs.getObject(field[i].getName())); //通过属性名获取结果集中的值赋值到实例对象中
                }
                list.add(obj);
            }            
            
           } 
        /********** End **********/
        
        catch (Exception e) {
            e.printStackTrace();
        }finally {    
            close(rs,ps,conn);
        }
        return list;
    }
    
    
    /**
     * 通过主键(默认第一个属性)删除对象
     * @param obj
     * @return
     */
    public static void delete(Object obj) {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	/********** Begin **********/
        ///获得obj的class;
         Class<?> c = obj.getClass();  
StringBuffer sb = new StringBuffer("delete from ");
sb.append(c.getSimpleName()).append(" where ");
Field[] field = c.getDeclaredFields();
//第一个属性可访问性
 field[0].setAccessible(true);
 sb.append(field[0].getName()).append("=?");

        String sql = sb.toString();
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,field[0].get(obj));  //预编译赋值
            System.out.println(field[0].get(obj));
            ps.execute();
        } 
        /********** End **********/
        
        catch (Exception e) {
            e.printStackTrace();
        }finally {    
            close(null,ps,conn);
        }
    }
    
    
    /**
     * 模拟jdbc的更新操作，默认第一个属性为主键
     * @param obj
     * @return
     */
    public void update(Object obj) {
    	Class<?> c = obj.getClass();//获取obj的Class
    	StringBuffer sb = new StringBuffer("update "+ c.getSimpleName() +" set ");//利用StringBuffer进行修改SQL语句的构造
    	Field[] field = c.getDeclaredFields();//通过反射获取对象的属性数组
    	for(int i = 1; i < field.length; i++) {
    		if(i != field.length-1) {    //判断是否为最后一个属性，若不是则后增加逗号
    			sb.append(field[i].getName()).append("=?,");
    		}else {    //若为最后一个属性则添加 where
    			sb.append(field[i].getName()).append("=? where ");
    		}
    	}
    	//默认第一个属性为主键，切更改时通过第一个属性进行更改
    	sb.append(field[0].getName() + "=?");
    	String sql = sb.toString()+";";
    	Connection conn = getConnection();//获取连接对象
    	PreparedStatement ps = null;
    	try {
    		ps = conn.prepareStatement(sql);
    		for(int i = 1; i < field.length; i++) {
    			field[i].setAccessible(true);//设置可以访问私有属性
    			ps.setObject(i, field[i].get(obj));//对预编译的SQL语句中的 ? 进行赋值
    		}
    		field[0].setAccessible(true);
    		ps.setObject(field.length, field[0].get(obj));
    		ps.execute();//执行sql语句
    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		close(null,ps,conn);//关闭连接数据
    	}
    }
    
    public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
    	try {
    		if(rs!=null) rs.close();
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

    @SuppressWarnings("deprecation")
	public static <T> Object selectById(Class<T> c,int id) {
        String sql = "select * from "+ c.getSimpleName()+" where id="+id;    
        Field[] field = c.getDeclaredFields();
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Object obj=null;
        try {
            ps = conn.prepareStatement(sql);  
            rs = ps.executeQuery(); 
            obj = c.newInstance();
            while(rs.next()) {
                for(int i = 0; i < field.length; i++) {      
                    field[i].setAccessible(true);           
                    field[i].set(obj, rs.getObject(field[i].getName()));   
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {    
            close(rs,ps,conn);
        }
        return obj;
    }
	
}
