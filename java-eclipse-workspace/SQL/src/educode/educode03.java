package educode;

import java.sql.*;
//�������ݿ� qquser������ݣ�
public class educode03 {
	// �޸�����
	public static void main(String[] args) throws SQLException {
		updateDB();
	}
	public static void updateDB()  throws SQLException{

		/********* Begin *********/
		 Connection conn = null;
		// ��һ������������
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

		// �ڶ�������������, "root"��"123123"�����MySQL�������û���(root)������(123123)�����
		// 127.0.0.1:3306��mysql��������ַ���˿�   ���ݿ�����ʽ����Ϊutf-8
		
		PreparedStatement ps = null;
		// ������������statement����
		// ���Ĳ����޸�����
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
                 System.out.println("�޸ĳɹ���");
	            
	        }catch(SQLException e){
	        	e.printStackTrace();
	            throw new SQLException(" ɾ������ʧ��");
	        }
	        finally{
	            close(null, ps, conn);
	        }        
		 
		// ���岽���ر�statement��������Ӷ���
		
		

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
