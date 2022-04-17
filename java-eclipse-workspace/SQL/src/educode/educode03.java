package educode;

import java.sql.*;
//连接数据库 qquser里的数据；
public class educode03 {
	// 修改数据
	public static void main(String[] args) throws SQLException {
		updateDB();
	}
	public static void updateDB()  throws SQLException{

		/********* Begin *********/
		 Connection conn = null;
		// 第一步：加载驱动
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
        }catch(ClassNotFoundException e) {
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

		// 第二步：建立连接, "root"和"123123"是针对MySQL设置了用户名(root)和密码(123123)的情况
		// 127.0.0.1:3306是mysql服务器地址及端口   数据库编码格式设置为utf-8
		
		PreparedStatement ps = null;
		// 第三步：建立statement对象
		// 第四步：修改数据
		StringBuffer sql = new StringBuffer("update qquser set password=? ");
		sql = sql.append(" where qqnumber = '3099722528' " + " ;");
		   try{
	              ps = conn.prepareStatement(sql.toString());
                  ps.setString(1,"hello");
                 ps.executeUpdate();
                  
//                  ResultSet rs =   ps.executeQuery();
////                  ps.executeUpdate();  
//                  while(rs.next()) {
//                	  String number = rs.getString("qqnumber");
//                	  String password = rs.getString("password");
//                	  System.out.println("| "+number +": "+ password+"  |");
//                  }
                 System.out.println("修改成功！");
	            
	        }catch(SQLException e){
	        	e.printStackTrace();
	            throw new SQLException(" 删除数据失败");
	        }
	        finally{
	            close(null, ps, conn);
	        }        
		 
		// 第五步：关闭statement对象和连接对象
		
		

		/********* End *********/
	}
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
