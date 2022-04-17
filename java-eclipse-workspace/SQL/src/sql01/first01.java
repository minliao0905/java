package sql01;
import java.sql.*;

public class first01 {

	public static void main(String[] args) throws SQLException {
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	    	//加载数据库驱动   java的反射机制
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 //通过DriverManager获取数据库连接
	    String url="jdbc:mysql://localhost:3306/jdbc";
	    String username = "root";
	    String password="root";
	    conn = DriverManager.getConnection(url,username,password);   //需要加上异常处理
	    //通过Connection 对象获取Statement 对象
	    stmt = conn.createStatement();
	    //使用Statement 执行sql语句
	    String sql = "select * from empolyees";
	    rs = stmt.executeQuery(sql);
	    //操作ResultSet结果集
	    System.out.println("| employee_id | employee_name | employee_sex | hire_date           |");
	    while(rs.next()) {
	    	int id=rs.getInt("employee_id");
	    	String  name = rs.getString("employ_name");
	    	String sex = rs.getString("employee_sex");
	    	Date  date = rs.getDate("hire_date");
	    	System.out.println("|"+ id+" | "+name+" | "+sex+" | "+date+"           |");
	    	
	    }
	    
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
	    	//关闭连接，释放资源
	    	if(rs!=null) {
	    		rs.close();
	    	}
	    	if(stmt!=null) {
	    		stmt.close();	
	    	}
	    	if(conn!=null) {
	    		conn.close();
	    	}
	    }
	   
	}

}
