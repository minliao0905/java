package educode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//ָ������JDBC��װ

public class educode01 {
	/**
	 * �������ݿ�
	 */
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		/**********   End   **********/
		return conn;
	}
	
	/**
     * �������ݷ���
     * @param news
     * @throws SQLException
     */
    public void update(News news) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        /*��һ�֣�
         *     PreparedStatement ps = null;
         *    ps = conn.prepareStatement(sql);    //���statement����  
         * �ڶ��֣�
         *  Statement stmt = null;
	     *  stmt = conn.createStatement();
	     *  	  
         * */
        /**********  Begin  **********/
        String sql = "update news set title=?,author_name=? where id=?";
       try{
            ps = conn.prepareStatement(sql);    //���statement����  
            ps.setString(1, news.getTitle());    //Ԥ���븳ֵ  
            ps.setString(2, news.getAuthor_name());  //news������ķ�������ֵ
            ps.setInt(3, news.getId());
            ps.executeUpdate();  
            
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("��������ʧ��");
        }finally{
            close(null, ps, conn);
        }    
        /**********  End  **********/
    }
    
    /**
     * ��ѯ��������
     * @return
     * @throws SQLException
     */
    public List<News> findAll() throws SQLException {
        Connection conn =  getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        News news = null;
        List<News> newsList = new ArrayList<News>();
        /**********  Begin  **********/
        String sql = "select * from news ";
        try{
          ps = conn.prepareStatement(sql);   
         //��ȡ���
         ResultSet r = ps.executeQuery();
        while(r.next()){
            //����news���� ����������
            news = new News();
            news.setId(r.getInt(1));
           news.setTitle(r.getString(2));
            news.setAuthor_name(r.getString(3));
          newsList.add(news);
        }
            
            
            
            
    
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("��ѯ��������ʧ��");
        }finally{
            close(rs, ps, conn);
        }
        /**********  End  **********/
        return newsList;
    }
	
	/**
	 * ɾ������
	 * @param id
	 * @throws SQLException
	 */
    public void delete(int id) throws SQLException{
        Connection conn = getConnection();
        PreparedStatement ps = null;
        /**********  Begin  **********/
        String sql = "delete from news where id = ?";
        try{
            
              ps = conn.prepareStatement(sql);
              ps.setInt(1,id);
              ps.executeUpdate();
        }catch(SQLException e){
        	e.printStackTrace();
            throw new SQLException(" ɾ������ʧ��");
        }
        finally{
            close(null, ps, conn);
        }        
        /**********  End  **********/
    }
    
    /**
     * ���Ӷ���
     * @param news
     * @throws SQLException
     */
    public void insert(News news) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        String sql = "insert into news(id,title,author_name)values(?,?,?)";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, news.getId());
            ps.setString(2, news.getTitle());
            ps.setString(3, news.getAuthor_name());
            ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("�������ʧ��");
        }finally{
           close(null, ps, conn);
        }
    }
    
    /**
     * ����id��ѯ����
     * @param id
     * @return
     * @throws SQLException
     */
    public News findById(int id) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        News news = null;
        String sql = "select * from news where id=?";
        try{
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if(rs.next()){
            	news = new News();
            	news.setId(id);
            	news.setTitle(rs.getString(2));
            	news.setAuthor_name(rs.getString(3));
            }
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("����ID��ѯ����ʧ��");
        }
        finally{
            close(rs, ps, conn);
        }
        return news;
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
