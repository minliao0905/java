package com.itheima.jdbc;
import java.sql.*;
import java.util.Date;

public class Example01 {

	public static void main(String[] args) throws SQLException {
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	    	//�������ݿ�����
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 //ͨ��DriverManager��ȡ���ݿ�����
	    String url="jdbc:mysql://localhost:3306/hr?useSSL=false";
	    String username = "root";
	    String password="123456";
	    conn = DriverManager.getConnection(url,username,password);   //��Ҫ�����쳣����
	    //ͨ��Connection �����ȡStatement ����
	    stmt = conn.createStatement();
	    //ʹ��Statement ִ��sql���
	    String sql = "select * from  employees";
	    rs = stmt.executeQuery(sql);
	    //����ResultSet�����
	    System.out.println("| employee_id | employee_name | employee_sex | hire_data|employee_salary|");
	    while(rs.next()) {
	    	int id=rs.getInt("employee_id");
	    	String  name = rs.getString("employee_name");
	    	String sex = rs.getString("employee_sex");
	    	Date  date = rs.getDate("hire_date");
	    	int salary = rs.getInt("employee_salary");
	    	System.out.println("|"+ id+"            | "+name+" |      "+sex+"          | "+date+"     |"+salary+"           |");
	    	
	    }
	    
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	    finally {
	    	//�ر����ӣ��ͷ���Դ
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
