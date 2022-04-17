package System_SQL;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class student_SQL {

	
	@SuppressWarnings("rawtypes")
	private Vector<Vector> studentData = new Vector<>();
	private Vector<Vector> m1Data = new Vector<>();
	private Vector<Vector> m2Data = new Vector<>();
	 //�������ݿ⣻
    private static Connection getConnection() {
    	Connection  conn =null;
    	//��������
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
	
	//��ȡ����ѧ����������
	@SuppressWarnings("rawtypes")    //Vector<Vector>
	public Vector<Vector> getstudentData() throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
			
		String sql="SELECT distinct a.*,b.classname,c.departmentname FROM students  as a,class as b,department as c "
				+ "where a.class = b.classid  "
				+ "and   a.department = c.departmentid  "
				+ "and b.departmentid = a.department;   " ;
	try {
		ps = conn.prepareStatement(sql);
		//��ȡ���
		rs = ps.executeQuery();	
		studentData.clear();
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("studentid"); 
			String studentid = String.valueOf(Id);   //��studentIdת��Ϊ�ַ������ͣ�
			String name = rs.getString("name");
			String gender= rs.getString("gender");
			String age = rs.getString("age");
			String studentclass = rs.getString("classname");
			String department = rs.getString("departmentname");
			String nativepalce = rs.getString("nativepalce");
			vector.addElement(studentid);
			vector.addElement(name);
			vector.addElement(gender);
			vector.addElement(age);
			vector.addElement(studentclass);
			vector.addElement(department);
			vector.addElement(nativepalce);
			studentData.add(vector);    //���Vector;
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ����ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   studentData;
	}
	//��ѯ��ñ�һ���
	public Vector<Vector> getstudentData_byid(String id) throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
			
	String sql="SELECT a.*,b.classname,c.departmentname FROM students  as a , class as b ,department as c "
			+ " where  a.class = b.classid "
			+ "and  a.department = c.departmentid  and a.studentid = ?";
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1,id);
		//��ȡ���
		rs = ps.executeQuery();	
		m1Data.clear();
		
		while(rs.next()) {
			Vector<String> vector = new Vector<String>();
			int Id = rs.getInt("studentid"); 
			String studentid = String.valueOf(Id);   //��studentIdת��Ϊ�ַ������ͣ�
			String name = rs.getString("name");
			String gender= rs.getString("gender");
			String age = rs.getString("age");
			String studentclass = rs.getString("classname");
			String department = rs.getString("departmentname");
			String nativepalce = rs.getString("nativepalce");
			vector.addElement(studentid);
			vector.addElement(name);
			vector.addElement(gender);
			vector.addElement(age);
			vector.addElement(studentclass);
			vector.addElement(department);
			vector.addElement(nativepalce);
			m1Data.add(vector);    //���Vector;
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ����ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
		
		 return   m1Data; 
	}
	//��ѯ��ñ�����
 
	public Vector<Vector> getstudentCRP_byid(String id) throws SQLException{
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		  m2Data.clear();
	 Vector<String> vector = new Vector<String>();	
		  String sql="select c.changeble,c.rec_time as changetime,cc.changeble as changename from changetabel as c,change_code as cc  " 
				+  "  where c.changeble = cc.id and c.studentnumber = ?     ;";
	try {
		//��ѯ1
		
		ps = conn.prepareStatement(sql);
		ps.setString(1,id);
		
		rs = ps.executeQuery();
		if(!rs.first()) {
			vector.addElement("��");
			vector.addElement("��");	
		}	
		else {				
			String change = rs.getString("changename");
			String changetime= rs.getString("changetime");
	
			vector.addElement(change);
			vector.addElement(changetime);
		   }
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯ���ݶ�ʧ��!");
		}finally {
			close(rs,ps,conn);
		}
	  conn = getConnection();
		
		//��ѯ��
 sql ="select  r.rewordlevel, r.rec_time as rewordtime,  rc.reward  from reword as r,reward_code as rc "
			+ " where r.rewordlevel = rc.id and r.studentnumber =? ;";
	try {
		
	ps = conn.prepareStatement(sql);
	ps.setString(1,id);
	rs = ps.executeQuery();	
	if(!rs.first()) {
		vector.addElement("��");
		vector.addElement("��");	
	}		
	else{
		String reward = rs.getString("reward");
		String rewardtime = rs.getString("rewordtime");	
	
		vector.addElement(reward);
		vector.addElement(rewardtime);		
	}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ���ݶ�ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
	
	
	//��ѯ��
	conn = getConnection();
   sql ="select  p.punishlevel , p.rec_time as punishtime, pc.punishment from punishment as p ,punishment_code as pc "
				+ "where p.punishlevel = pc.id and p.studentnumber = ? ;";
	
	try {
		
		ps = conn.prepareStatement(sql);
		ps.setString(1,id);
		rs = ps.executeQuery();	
		if(!rs.first()) {
			vector.addElement("��");
			vector.addElement("��");	
		}	
		else {
			
			String punishment = rs.getString("punishment");
			String punimenttime = rs.getString("punishtime");
		
			vector.addElement(punishment);
			vector.addElement(punimenttime);
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ������ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
	m2Data.add(vector);
		 return   m2Data;
	}
	
	
	
	
	public Vector<String> getid_byname(String studentname) throws SQLException {
		String studentid = null;
		Connection  conn = getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
	    Vector<String> vector = new Vector<String>();
	String sql="select studentid from students where name = ?";
	try {
		ps = conn.prepareStatement(sql);
		ps.setString(1,studentname);
		//��ȡ���
		rs = ps.executeQuery();	
		while(rs.next()) {			
			int Id = rs.getInt("studentid"); 
			 studentid = String.valueOf(Id);   //��studentIdת��Ϊ�ַ������ͣ�
			 vector.add(studentid);
		}
	}catch(SQLException e){
		e.printStackTrace();
		throw new SQLException("��ѯ����ʧ��!");
	}finally {
		close(rs,ps,conn);
	}
	return vector;
		
	}
	//��ȡ���
	//��������������ݲ�����Ҫ����Ƿ�Ϊ�ջ��ظ���
	public void InsertIntostudent(Map<String,String> params) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into students(studentid,name,gender,age,class,department,nativepalce) values(?,?,?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  
			 // �Ȼ�ȡmap���������еļ���Set���ϣ� ketSet();
	        Set<String> keySet = params.keySet();
	        int i=1;
	        for (Iterator<String> it = keySet.iterator(); it.hasNext(); )
	        {   
	            String key = it.next();
	            // ���˼�����ͨ��map���ϵ�get������ȡ��ȡ���Ӧ��ֵ��
	            String value = params.get(key);
//	            System.out.println("key:"+key +"  value:"+value);  //�����֤
	            ps.setString(i, value);
	            i++;
	        }	
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("�������ʧ��");
		}finally {
			close(rs,ps,conn);
		}
		
	}
	public void Insertnewstudent(Vector<String> studentData) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "insert into students(studentid,name,gender,age,class,department,nativepalce) values(?,?,?,?,?,?,?) ";
		try {
			  ps = conn.prepareStatement(sql);
			  int i=1;
			  System.out.println("sql"+studentData);
			for(String item :studentData) {
				
				ps.setString(i, item);
				i++;
			}
	      
	        ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("�������ʧ��");
		}finally {
			close(rs,ps,conn);
		}
		
	}
	
	//ɾ������
	public void Deletestudent(String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete from  students  where studentid = ? ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.setString(1,id);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("ɾ������ʧ��");
		}finally {
			close(rs,ps,conn);
		}
	}
	
	public void updatestudent(Map<String, String> params,String id) throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "update students set studentid=?,name=?,gender=?,age=?,class=?,department=?,nativepalce=?   where studentid=? ";
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
			close(rs,ps,conn);
		}
		
		
	}
	public void deleteAllstudents() throws SQLException{
		Connection conn =  getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "delete  from  students  ";
		try {
			  ps = conn.prepareStatement(sql);
			  ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
			throw new SQLException("ɾ����������ʧ��");
		}finally {
			close(rs,ps,conn);
		}
	}
	public Boolean checkAllstudentsId(String studentId) throws SQLException{
		Boolean check = true;
		 Connection conn =  getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select studentid  from   students ";
			try {
				  ps = conn.prepareStatement(sql);
			      rs =   ps.executeQuery();
			  	while(rs.next()) {
					String id = rs.getString("studentid");
					if(studentId.equals(id)) {
						check = false;
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
	public Boolean checkAllclass_departmentId(String departmentId,String classId) throws SQLException{
	
		 Connection conn =  getConnection();
			PreparedStatement ps = null;
			ResultSet rs = null;
			String sql = "select   departmentid,classid  from   class  where departmentid = ? and classid = ?";
			try {
			  
			   ps = conn.prepareStatement(sql); 
			   ps.setString(1,departmentId );
			   ps.setString(2, classId);
			   rs = ps.executeQuery();
			      
			  if(rs.next()) {
				  return true;      //����༶��רҵ��Ŵ���
			  }
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
				close(rs,ps,conn);
			}
		
		 return false;
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
