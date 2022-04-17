package educode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//指定类型JDBC封装

public class educode01 {
	/**
	 * 连接数据库
	 */
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
		}catch (SQLException e) {
			e.printStackTrace();
		}
		/**********   End   **********/
		return conn;
	}
	
	/**
     * 更新数据方法
     * @param news
     * @throws SQLException
     */
    public void update(News news) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement ps = null;
        /*第一种：
         *     PreparedStatement ps = null;
         *    ps = conn.prepareStatement(sql);    //获得statement对象  
         * 第二种：
         *  Statement stmt = null;
	     *  stmt = conn.createStatement();
	     *  	  
         * */
        /**********  Begin  **********/
        String sql = "update news set title=?,author_name=? where id=?";
       try{
            ps = conn.prepareStatement(sql);    //获得statement对象  
            ps.setString(1, news.getTitle());    //预编译赋值  
            ps.setString(2, news.getAuthor_name());  //news对象里的方法返回值
            ps.setInt(3, news.getId());
            ps.executeUpdate();  
            
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("更新数据失败");
        }finally{
            close(null, ps, conn);
        }    
        /**********  End  **********/
    }
    
    /**
     * 查询所有数据
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
         //获取结果
         ResultSet r = ps.executeQuery();
        while(r.next()){
            //定义news对象 ，存入数据
            news = new News();
            news.setId(r.getInt(1));
           news.setTitle(r.getString(2));
            news.setAuthor_name(r.getString(3));
          newsList.add(news);
        }
            
            
            
            
    
        }catch(SQLException e){
            e.printStackTrace();
            throw new SQLException("查询所有数据失败");
        }finally{
            close(rs, ps, conn);
        }
        /**********  End  **********/
        return newsList;
    }
	
	/**
	 * 删除方法
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
            throw new SQLException(" 删除数据失败");
        }
        finally{
            close(null, ps, conn);
        }        
        /**********  End  **********/
    }
    
    /**
     * 增加对象
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
            throw new SQLException("添加数据失败");
        }finally{
           close(null, ps, conn);
        }
    }
    
    /**
     * 根据id查询对象
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
            throw new SQLException("根据ID查询数据失败");
        }
        finally{
            close(rs, ps, conn);
        }
        return news;
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
