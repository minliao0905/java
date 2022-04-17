package sql01;
import java.sql.*;

public class first01 {

	public static void main(String[] args) throws SQLException {
	    Connection conn = null;
	    Statement stmt = null;
	    ResultSet rs = null;
	    try {
	    	//�������ݿ�����   java�ķ������
	    	Class.forName("com.mysql.jdbc.Driver");
	    	 //ͨ��DriverManager��ȡ���ݿ�����
	    String url="jdbc:mysql://localhost:3306/jdbc";
	    String username = "root";
	    String password="root";
	    conn = DriverManager.getConnection(url,username,password);   //��Ҫ�����쳣����
	    //ͨ��Connection �����ȡStatement ����
	    stmt = conn.createStatement();
	    //ʹ��Statement ִ��sql���
	    String sql = "select * from empolyees";
	    rs = stmt.executeQuery(sql);
	    //����ResultSet�����
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
