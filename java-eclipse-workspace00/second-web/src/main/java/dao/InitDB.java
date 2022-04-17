package dao;

import java.io.File;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.SQLExec;

public class InitDB {

	/** mysql服务器ip和端口 **/
	static final String url = "127.0.0.1:3306";

	private final static String DRIVER = "com.mysql.jdbc.Driver";

	static final String USERNAME = "root";

	static final String PASSWORD = "123456";

	static final String URL = "jdbc:mysql://" + url
			+ "/online_shop?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";

	static final java.util.Properties info = new Properties();

	static {
		try {
			Class.forName(DRIVER);// 加载驱动
		} catch (ClassNotFoundException e) {
			System.out.println("驱动找不到");
			e.printStackTrace();
		}
		// 设置用户名和密码
		info.put("user", USERNAME);
		info.put("password", PASSWORD);
	}

	public void createDb() throws URISyntaxException {
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://" + url + "/information_schema", info);
			Statement createStatement = connection.createStatement();

			// 如果存在db,先删除db,再进行创建
			createStatement.execute("drop database if exists online_shop");
			// 创建db
			createStatement.execute("create database online_shop");

			initTable();

		} catch (SQLException e) {
			//
			e.printStackTrace();
		} finally {
			try {
				if (statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				//
				e.printStackTrace();
			}
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

	}

	public void initTable() throws URISyntaxException {
		// 创建ScriptRunner，用于执行SQL脚本
		SQLExec sqlExec = new SQLExec();
		// 设置数据库参数
		sqlExec.setDriver(DRIVER);
		sqlExec.setUrl(URL);
		sqlExec.setUserid(USERNAME);
		sqlExec.setPassword(PASSWORD);
		sqlExec.setEncoding("utf-8");
		// 要执行的脚本
		java.net.URL resource = InitDB.class.getClassLoader().getResource("online_shop.sql");
		sqlExec.setSrc(new File(resource.toURI()));
		sqlExec.setProject(new Project()); // 要指定这个属性，不然会出错
		sqlExec.execute();
	}

}
