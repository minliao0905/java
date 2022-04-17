package com.one.component01;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class BookSystem_Sqllogin {

	private Vector<Vector> tableData = new Vector<>();
	 //�������ݿ⣻
	private static Connection getConnection() {
		Connection conn=null;
		/**********  Begin  **********/
		try {
            //��ȡ��������
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hr?useSSL=false";
			String username = "root";
			String password = "123456";
		    conn = DriverManager.getConnection(url,username,password);
		
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e){
			e.printStackTrace();
		}
		/**********   End   **********/
		return conn;
	}
	
	//��ȡ�����������
	public Vector<Vector> getBookData() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	String sql="Select * from booksystem ";
	try {
		ps = conn.prepareStatement(sql);
		//��ȡ���
		rs = ps.executeQuery();	
		tableData.clear();//���tableData�������
		
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("id"); 
			String bookId = String.valueOf(Id);   //��bookIdת��Ϊ�ַ������ͣ�
    
//			id`, `bookname`, `bookAuthor`, `bookprice`, `bookstorage
			String bookname = rs.getString("bookname");
			String bookAuthor = rs.getString("bookAuthor");
			String bookprice = rs.getString("bookprice");
			String bookstorage = rs.getString("bookstorage");
			String bookIntroduce = rs.getString("bookIntroduce");
			vector.addElement(bookId);
			vector.addElement(bookname);
			vector.addElement(bookAuthor);
			vector.addElement(bookprice);
			vector.addElement(bookstorage);
			vector.addElement(bookIntroduce);
			tableData.addElement(vector);
			
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ����ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   tableData;
	}
	
	//�������
	public void InsertBook(Map<String,String> params) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into booksystem(bookname,bookAuthor,bookprice,bookstorage,bookIntroduce) values(?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // �Ȼ�ȡmap���������еļ���Set���ϣ� ketSet();
	        Set<String> keySet = params.keySet();
	 
	        // ����Set���ϣ� �Ϳ��Ի�ȡ���������
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
	            String value = params.get(key);
	            System.out.println("key:"+key +"  value:"+value);
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("�������ʧ��");
		}finally {
			close(null,ps,conn);
		}
		
	}
	
	//ɾ������
	public void DeleteBook(String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from  booksystem  where id = ? ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.setString(1,id);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("ɾ������ʧ��");
		}finally {
			close(null,ps,conn);
		}
	}
	
	public void updateBook(Map<String, String> params,String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update booksystem set bookname=?,bookAuthor=?,bookprice=?,bookstorage=?,bookIntroduce=?   where id=? ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // �Ȼ�ȡmap���������еļ���Set���ϣ� ketSet();
	        Set<String> keySet = params.keySet();
	 
	        // ����Set���ϣ� �Ϳ��Ի�ȡ���������
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
	            String value = params.get(key);
	            ps.setString(i, value);
	            i++;
	        }
	        ps.setString(i, id);
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("�޸�����ʧ��");
		}finally {
			close(null,ps,conn);
		}
		
		
	}
	 /**
     * �ر����ݿ�����
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
