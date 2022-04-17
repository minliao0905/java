package com.itheima.jdbc;
import java.sql.*;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

public class Logindao {
PreparedStatement prestmt = null;
Connection conn =null;
ResultSet rs = null;
public List<String> getUsers() throws SQLException{
    List<String> list=new ArrayList<String>();
	try {
		Class.forName("com.mysql.jdbc.Driver");		
		String url = "jdbc:mysql://localhost:3306/hr?useSSL=false";
		String username = "root";
		String password = "123456";
		//获取数据库连接；
		conn=DriverManager.getConnection(url,username,password);	
	    Statement stmt = null;
	    stmt = conn.createStatement();	               //通过Connection 对象获取Statement 对象
	    String sql = "select * from qquser " + " limit 3";   //保持输出三个账号就可以了
	    rs = stmt.executeQuery(sql);
	    while(rs.next()) {   //获取数据
	    	
	        String str=rs.getString("qqnumber");
	        
	    	list.add(str);       //1str中添加元素
	    	 
	    	System.out.println(str+"   ---getuser ok!");   //2输出确认	    	
	    }		
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		//释放资源
		if(rs!=null) {rs.close();
		}
		if(prestmt!=null) {
			prestmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
	return list;
}
public boolean findUser(String qqnumber,String pwd) throws SQLException{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/hr?useSSL=false";
		String username = "root";
		String password = "123456";
		//获取数据库连接；
		conn=DriverManager.getConnection(url,username,password);
		//定义需要执行的sql     在定义的sql中使用占位符"?" 来表示查询条件，使用PreparedStatement对象的setString()方法设置参数值
		String sql = "select * from qquser "+"where qqnumber=? "+" and password=?";  //语句之间要加上空格 不然否则可能是连在一起的
		//创建preparedStatement对象
		prestmt = conn.prepareStatement(sql);
		prestmt.setString(1,qqnumber);
		prestmt.setString(2,pwd);
		//执行sql并将获取的数据信息存放在resultSet中
		rs = prestmt.executeQuery();
		//如果查询的结果集合中有超过一条的记录，则登录成功
		if(rs.next()) {return true;}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		//释放资源
		if(rs!=null) {rs.close();
		}
		if(prestmt!=null) {
			prestmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
	return false;
	
}

public boolean AddUser(String qqnumber,String pwd)throws SQLException{
	try {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/hr?useSSL=false";
		String username = "root";
		String password = "123456";				
			//获取数据库连接；
		conn=DriverManager.getConnection(url,username,password);	
		//获取数据库连接；
				conn=DriverManager.getConnection(url,username,password);
				//定义需要执行的sql     在定义的sql中使用占位符"?" 来表示查询条件，使用PreparedStatement对象的setString()方法设置参数值
				String sql = "insert qquser(qqnumber,password) values(?,?) ";  //语句之间要加上空格 不然否则可能是连在一起的
				//创建preparedStatement对象
				prestmt = conn.prepareStatement(sql);
				prestmt.setString(1,qqnumber);
				prestmt.setString(2,pwd);
				//执行sql并将获取的数据信息存放在resultSet中
				prestmt.executeUpdate();
				
	}catch(Exception e) {
		e.printStackTrace();	
	}
	finally {
		//释放资源
		if(rs!=null) {rs.close();
		}
		if(prestmt!=null) {
			prestmt.close();
		}
		if(conn!=null) {
			conn.close();
		}
	}
return true;
}

}
