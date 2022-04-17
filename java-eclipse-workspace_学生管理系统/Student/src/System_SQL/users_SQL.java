package System_SQL;

import java.sql.*;
import java.util.Map;
import java.util.Set;
import java.util.Iterator;


public class users_SQL { 
	
	//默认加载
    private static Connection getConnection() {
    	Connection  conn =null;
    	//加载连接
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		String url = "jdbc:mysql://localhost:3306/studentmanager?useSSL=false&useUnicode=true&characterEncoding=UTF8";
    		String  sqlusername = "root";
    		String sqlpassword = "123456";
    		conn = DriverManager.getConnection(url,sqlusername,sqlpassword);
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return conn;
    }
    
    //核对用户信息
	public Boolean findUser(String username, String password) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " select * from  users where  username = ? " + " and password = ? ";
	   try {
		   ps= conn.prepareStatement(sql);
		   ps.setString(1, username);
		   ps.setString(2, password);
		   //获取结果
		   rs = ps.executeQuery();
		   if(rs.next()) {
			   return true;  //结果不为空,则返回true;
		   } 	   
	   }catch(Exception e){
		   e.printStackTrace();
	   }finally {
		   close(rs,ps,conn);
	   }
		return false;
	}
	
	//添加新用户
	public Boolean Insertuser(Map<String,String> params) throws SQLException{
		Connection conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " insert into users(username,password,phonenumber,gender) values(?,?,?,?) ";
		try {
			   ps= conn.prepareStatement(sql);			
			Set<String> keySet = params.keySet();
			int i=1;
			for(Iterator<String> it  =keySet.iterator(); it.hasNext();) {
				String key = it.next();
				String value = params.get(key);
				//输出验证
				System.out.println("key: "+key+" value:"+value);
				ps.setString(i, value);
				i++;
			}
			ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加用户失败");
		}finally {
			close(rs,ps,conn);
		}
		return false; 
	}

	 /**
     * 关闭数据库连接
     * @param rs
     * @param ps
     * @param conn
     */
    public static void close(ResultSet rs,PreparedStatement ps,Connection conn){
    	try {
    		if(rs!=null)rs.close();
    		if(ps!=null)ps.close();
    		if(conn!=null)conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }

}
