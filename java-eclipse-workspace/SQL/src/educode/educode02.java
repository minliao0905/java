package educode;
//�أ�������JDBC��װ
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
//����ɾ��		
		Object ob = new News(4," 123456","123");    //object�Ǵ���News����
		insert(ob);
//      delete(ob);
//������ʾ
		@SuppressWarnings("rawtypes")
		Class  clazz = null;
		try {
			  clazz = Class.forName("educode.News");     //���News����
		}catch(Exception e) {
			e.printStackTrace();
		}
     
		List<News> list = new ArrayList<News>();
		list = selectAll(clazz);
		for(News i :list) {
			System.out.println(i);
		}
//
//ѡ���ӡ��	
//		Class  clazz = null;
//		try {
//			  clazz = Class.forName("educode.News");     //���News����
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		Object ob1 = new News();
//		ob1 = selectById(clazz,1);
//		System.out.println(ob1);

	}
	//��ȡ���ݿ�����
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
     * ������Ӧ�����Զ�Ӧ�ֶ�
     * @param obj��������Ķ���
     * @return
     */
    public static void insert(Object obj) {
    	Connection conn = getConnection();  //�������ݿ�
    	PreparedStatement ps = null;        
    	/********** Begin **********/
    	  Class<?> c = obj.getClass();//��ȡobj��Class
          StringBuffer sb1 = new StringBuffer("insert "+ c.getSimpleName() +" ( ");         //����StringBuffer�����޸�SQL���Ĺ���
          StringBuffer sb2 = new StringBuffer(" values(");  
          Field[] field = c.getDeclaredFields();
          for(int i = 0; i < field.length; i++){           //�������Թ���SQL���
            if(i != field.length-1) {
                sb1.append(field[i].getName()).append(",");
                sb2.append("?,");
            }else {
                sb1.append(field[i].getName()).append(")");
                sb2.append("?);");
            }
        }
        String sql = sb1.append(sb2).toString();   //ƴ��������䲢��toString();
      
        try {
              ps = conn.prepareStatement(sql);
            for(int i = 0; i < field.length; i++) {    
                field[i].setAccessible(true);                    //�������ԵĿɷ����ԣ����Է���˽������
                try {                                            //ͨ��Field��get(Object)������ȡObject���������ֵ
                    ps.setObject(i+1, field[i].get(obj));        //��Ԥ�����SQL����еģ����и�ֵ
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            ps.execute();        //ִ��SQL

        }       
        /********** End **********/
        
        catch (SQLException e) {
            e.printStackTrace();
        }finally {    
            close(null,ps,conn);
        }
    }
    
    /**
     * ͨ�������Class��ȡ��Ӧ���е����м�¼
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
        String sql = "select * from " + c.getSimpleName()+";";  //ͨ�������ȡ������Ӧ��������SQL���
        Field[] field = c.getDeclaredFields();                   //ͨ�������ȡ��������

        try {
            
            ps = conn.prepareStatement(sql); 
            rs = ps.executeQuery();
            while(rs.next()){
                T obj = c.newInstance();       //��������   class c = Class.forName(��Example��);   factory = (ExampleInterface)c.newInstance();  
                for(int i=0;i<field.length;i++){
                    //���÷���Ȩ�ޣ�
                    field[i].setAccessible(true);
                    field[i].set(obj,rs.getObject(field[i].getName())); //ͨ����������ȡ������е�ֵ��ֵ��ʵ��������
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
     * ͨ������(Ĭ�ϵ�һ������)ɾ������
     * @param obj
     * @return
     */
    public static void delete(Object obj) {
    	Connection conn = getConnection();
    	PreparedStatement ps = null;
    	/********** Begin **********/
        ///���obj��class;
         Class<?> c = obj.getClass();  
StringBuffer sb = new StringBuffer("delete from ");
sb.append(c.getSimpleName()).append(" where ");
Field[] field = c.getDeclaredFields();
//��һ�����Կɷ�����
 field[0].setAccessible(true);
 sb.append(field[0].getName()).append("=?");

        String sql = sb.toString();
        try {
            ps = conn.prepareStatement(sql);
            ps.setObject(1,field[0].get(obj));  //Ԥ���븳ֵ
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
     * ģ��jdbc�ĸ��²�����Ĭ�ϵ�һ������Ϊ����
     * @param obj
     * @return
     */
    public void update(Object obj) {
    	Class<?> c = obj.getClass();//��ȡobj��Class
    	StringBuffer sb = new StringBuffer("update "+ c.getSimpleName() +" set ");//����StringBuffer�����޸�SQL���Ĺ���
    	Field[] field = c.getDeclaredFields();//ͨ�������ȡ�������������
    	for(int i = 1; i < field.length; i++) {
    		if(i != field.length-1) {    //�ж��Ƿ�Ϊ���һ�����ԣ�������������Ӷ���
    			sb.append(field[i].getName()).append("=?,");
    		}else {    //��Ϊ���һ����������� where
    			sb.append(field[i].getName()).append("=? where ");
    		}
    	}
    	//Ĭ�ϵ�һ������Ϊ�������и���ʱͨ����һ�����Խ��и���
    	sb.append(field[0].getName() + "=?");
    	String sql = sb.toString()+";";
    	Connection conn = getConnection();//��ȡ���Ӷ���
    	PreparedStatement ps = null;
    	try {
    		ps = conn.prepareStatement(sql);
    		for(int i = 1; i < field.length; i++) {
    			field[i].setAccessible(true);//���ÿ��Է���˽������
    			ps.setObject(i, field[i].get(obj));//��Ԥ�����SQL����е� ? ���и�ֵ
    		}
    		field[0].setAccessible(true);
    		ps.setObject(field.length, field[0].get(obj));
    		ps.execute();//ִ��sql���
    	} catch (Exception e) {
    		e.printStackTrace();
    	}finally {
    		close(null,ps,conn);//�ر���������
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
