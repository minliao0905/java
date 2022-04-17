package System_SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Manager_SQl {

	
	
	private Vector<Vector> studentData = new Vector<>();
	private Vector<Vector> Manager1Data = new Vector<>();
	private Vector<Vector> Manager2Data = new Vector<>();
	private Vector<Vector> Manager3Data = new Vector<>();
	 //连接数据库；
    private static Connection getConnection() {
    	Connection  conn =null;
    	//加载连接
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    		String url = "jdbc:mysql://localhost:3306/studentmanager?useSSL=false&useUnicode=true&characterEncoding=UTF8";
    		String  sqlusername = "root";
    		String sqlpassword = "123456";
    		conn = DriverManager.getConnection(url,sqlusername,sqlpassword);
    	}catch(ClassNotFoundException e) {
    		e.printStackTrace();
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    	return conn;
    }
	
	//获取整个学生个人资料
	@SuppressWarnings("rawtypes")    //Vector<Vector>\
	
	//表一学籍变更
	public Vector<Vector> getManager1Data() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql="Select * from changetabel ";
	try {
		ps = conn.prepareStatement(sql);
		//获取结果
		rs = ps.executeQuery();	
		Manager1Data.clear();
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("id"); 
			String id = String.valueOf(Id);   //将studentId转换为字符串类型；
			String change = rs.getString("changeble");    //获取级别编号
			String name= rs.getString("student");
			String studentnumber = rs.getString("studentnumber");
			String rec_time = rs.getString("rec_time");
			String decription = rs.getString("decription");
			
			vector.addElement(id);
			vector.addElement(change);
			vector.addElement(name);
			vector.addElement(studentnumber);
			vector.addElement(rec_time);
			vector.addElement(decription);
			
			Manager1Data.add(vector);    //添加Vector;
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("查询数据失败!");
	}finally {
		close(rs,ps,conn);
	}
//	String sql2	="select changeble from changeble  where id = ? ";
	
		
		 return   Manager1Data;
	}
	
	
	//  表二奖惩
	@SuppressWarnings("rawtypes")    //Vector<Vector>
	public Vector<Vector> getManager2Data() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
	String sql="Select * from  reword ";
	try {
		ps = conn.prepareStatement(sql);
		//获取结果
		rs = ps.executeQuery();	
		Manager2Data.clear();
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("id"); 
			String id = String.valueOf(Id);   //将studentId转换为字符串类型；
			String rewordlevel = rs.getString("rewordlevel");
			String name= rs.getString("studentname");
			String studentnumber = rs.getString("studentnumber");
			String rec_time = rs.getString("rec_time");
			String decription = rs.getString("description");
			
			vector.addElement(id);
			vector.addElement(rewordlevel);
			vector.addElement(name);
			vector.addElement(studentnumber);		
			vector.addElement(rec_time);
			vector.addElement(decription);
			
			Manager2Data.add(vector);    //添加Vector;
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("查询数据失败!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   Manager2Data;
	}
	
	
	
	//表二处分
	@SuppressWarnings("rawtypes")    //Vector<Vector>
	public Vector<Vector> getManager3Data() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
	String sql="Select * from  punishment  ";
	try {
		ps = conn.prepareStatement(sql);
		//获取结果
		rs = ps.executeQuery();	
	     Manager3Data.clear();
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("id"); 
			String id = String.valueOf(Id);   //将studentId转换为字符串类型；
			String punishment = rs.getString("punishlevel");
			String name= rs.getString("studentname");
			String studentnumber = rs.getString("studentnumber");
			String rec_time = rs.getString("rec_time");
			String decription = rs.getString("discription");
			String makesence = rs.getString("makesence");
			vector.addElement(id);
			vector.addElement(punishment);
			vector.addElement(name);
			vector.addElement(studentnumber);
			vector.addElement(rec_time);
			vector.addElement(decription);
			vector.addElement(makesence);
			Manager3Data.add(vector);    //添加Vector;
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("查询数据失败!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   Manager3Data;
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

	public void InsertIntochange(Map<String, String> params) throws SQLException {
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into changetabel(id,changeble,student,studentnumber,rec_time,decription) values(?,?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // 先获取map集合中所有的键的Set集合， ketSet();
	        Set<String> keySet = params.keySet();
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // 有了键可以通过map集合的get方法获取获取其对应的值。
	            String value = params.get(key);
//	            System.out.println("key:"+key +"  value:"+value);  //输出验证
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally {
			close(rs,ps,conn);
		}	
	}
	public void InsertIntoreword(Map<String, String> params) throws SQLException {
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into reword(id,rewordlevel,studentname,studentnumber,rec_time,description) values(?,?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // 先获取map集合中所有的键的Set集合， ketSet();
	        Set<String> keySet = params.keySet();
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // 有了键可以通过map集合的get方法获取获取其对应的值。
	            String value = params.get(key);
//	            System.out.println("key:"+key +"  value:"+value);  //输出验证
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally {
			close(rs,ps,conn);
		}	
	}
	public void InsertIntopunishment(Map<String, String> params) throws SQLException {
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into punishment(id,punishlevel,studentname,studentnumber,rec_time,discription,makesence) values(?,?,?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // 先获取map集合中所有的键的Set集合， ketSet();
	        Set<String> keySet = params.keySet();
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // 有了键可以通过map集合的get方法获取获取其对应的值。
	            String value = params.get(key);
//	            System.out.println("key:"+key +"  value:"+value);  //输出验证
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("添加数据失败");
		}finally {
			close(rs,ps,conn);
		}	
	}
	public void updateIntochange(Map<String,String> params,String id)throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update changetabel  set id = ?,changeble = ?,student=?,studentnumber=?,rec_time=?,decription=?  where id=?";
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
			close(rs,ps,conn);
		}
		
	}
	public void updateIntoreword(Map<String,String> params,String id)throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update reword  set id = ?,rewordlevel = ?,studentname=?,studentnumber=?,rec_time=?,decription=?  where id=?";
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
			close(rs,ps,conn);
		}
		
	}
	public void updateIntopunishment(Map<String,String> params,String id)throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update punishment  set id=?,punishlevel=?,studentname=?,studentnumber=?,rec_time=?,discription=?,makesence=?  where id=?";
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
			close(rs,ps,conn);
		}
		
	}
	public void Deleteschange(String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from  changetabel   where id = ? ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.setString(1,id);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally {
			close(rs,ps,conn);
		}
	}
	public void Deletereword(String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from  reword   where id = ? ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.setString(1,id);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally {
			close(rs,ps,conn);
		}
	}
	public void Deletepunishment(String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from  punishment   where id = ? ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.setString(1,id);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("删除数据失败");
		}finally {
			close(rs,ps,conn);
		}
	}
	public Boolean checkAllstudentsId(String studentId) throws SQLException{
		Boolean check = false;
		 Connection conn =  getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select studentid  from   students ";
			try {
				  ps = conn.prepareStatement(sql);
			      rs =   ps.executeQuery();
			  	while(rs.next()) {
					String id = rs.getString("studentid");
					if(studentId.equals(id)) {             //若该学号存在
						check = true;
						break;
						}
				}  
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs,ps,conn);
			}		
		 return check;
	}
}