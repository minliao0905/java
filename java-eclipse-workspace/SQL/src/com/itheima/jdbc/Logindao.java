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
		//��ȡ���ݿ����ӣ�
		conn=DriverManager.getConnection(url,username,password);	
	    Statement stmt = null;
	    stmt = conn.createStatement();	               //ͨ��Connection �����ȡStatement ����
	    String sql = "select * from qquser " + " limit 3";   //������������˺žͿ�����
	    rs = stmt.executeQuery(sql);
	    while(rs.next()) {   //��ȡ����
	    	
	        String str=rs.getString("qqnumber");
	        
	    	list.add(str);       //1str�����Ԫ��
	    	 
	    	System.out.println(str+"   ---getuser ok!");   //2���ȷ��	    	
	    }		
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		//�ͷ���Դ
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
		//��ȡ���ݿ����ӣ�
		conn=DriverManager.getConnection(url,username,password);
		//������Ҫִ�е�sql     �ڶ����sql��ʹ��ռλ��"?" ����ʾ��ѯ������ʹ��PreparedStatement�����setString()�������ò���ֵ
		String sql = "select * from qquser "+"where qqnumber=? "+" and password=?";  //���֮��Ҫ���Ͽո� ��Ȼ�������������һ���
		//����preparedStatement����
		prestmt = conn.prepareStatement(sql);
		prestmt.setString(1,qqnumber);
		prestmt.setString(2,pwd);
		//ִ��sql������ȡ��������Ϣ�����resultSet��
		rs = prestmt.executeQuery();
		//�����ѯ�Ľ���������г���һ���ļ�¼�����¼�ɹ�
		if(rs.next()) {return true;}
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		//�ͷ���Դ
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
			//��ȡ���ݿ����ӣ�
		conn=DriverManager.getConnection(url,username,password);	
		//��ȡ���ݿ����ӣ�
				conn=DriverManager.getConnection(url,username,password);
				//������Ҫִ�е�sql     �ڶ����sql��ʹ��ռλ��"?" ����ʾ��ѯ������ʹ��PreparedStatement�����setString()�������ò���ֵ
				String sql = "insert qquser(qqnumber,password) values(?,?) ";  //���֮��Ҫ���Ͽո� ��Ȼ�������������һ���
				//����preparedStatement����
				prestmt = conn.prepareStatement(sql);
				prestmt.setString(1,qqnumber);
				prestmt.setString(2,pwd);
				//ִ��sql������ȡ��������Ϣ�����resultSet��
				prestmt.executeUpdate();
				
	}catch(Exception e) {
		e.printStackTrace();	
	}
	finally {
		//�ͷ���Դ
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
