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
	 //连接数据库；
	private static Connection getConnection() {
		Connection conn=null;
		/**********  Begin  **********/
		try {
            //获取加载驱动
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
	
	//获取整个书库资料
	public Vector<Vector> getBookData() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
	String sql="Select * from booksystem ";
	try {
		ps = conn.prepareStatement(sql);
		//获取结果
		rs = ps.executeQuery();	
		tableData.clear();//清空tableData里的数据
		
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("id"); 
			String bookId = String.valueOf(Id);   //将bookId转换为字符串类型；
    
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
		throw new SQLException("查询数据失败!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   tableData;
	}
	
	//添加数据
	public void InsertBook(Map<String,String> params) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into booksystem(bookname,bookAuthor,bookprice,bookstorage,bookIntroduce) values(?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // 先获取map集合中所有的键的Set集合， ketSet();
	        Set<String> keySet = params.keySet();
	 
	        // 有了Set集合， 就可以获取其迭代器。
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // 有了键可以通过map集合的get方法获取获取其对应的值。
	            String value = params.get(key);
	            System.out.println("key:"+key +"  value:"+value);
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally {
			close(null,ps,conn);
		}
		
	}
	
	//删除数据
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
			throw new SQLException("删除数据失败");
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
			  
			 // 先获取map集合中所有的键的Set集合， ketSet();
	        Set<String> keySet = params.keySet();
	 
	        // 有了Set集合， 就可以获取其迭代器。
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // 有了键可以通过map集合的get方法获取获取其对应的值。
	            String value = params.get(key);
	            ps.setString(i, value);
	            i++;
	        }
	        ps.setString(i, id);
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("修改数据失败");
		}finally {
			close(null,ps,conn);
		}
		
		
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
