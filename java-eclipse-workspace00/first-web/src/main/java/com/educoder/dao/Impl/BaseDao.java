package com.educoder.dao.Impl;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BaseDao extends InitDB {

	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static boolean operUpdate(String sql, List<Object> p) {
		Connection conn = null;
		PreparedStatement pste = null;
		int res = 0;
		conn = getConn();
		try {
			pste = conn.prepareStatement(sql);
			if (p != null) {
				for (int i = 0; i < p.size(); i++) {
					pste.setObject(i + 1, p.get(i));
				}
			}
			res = pste.executeUpdate();
			// 鎵ц
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll(null, pste, conn);
		}
		return res > 0;//
	}

	public static <T> List<T> operQuery(String sql, List<Object> p, Class<T> cls) throws Exception {
		Connection conn = null;
		PreparedStatement pste = null;
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		conn = getConn();
		try {
			pste = conn.prepareStatement(sql);
			if (p != null) {
				for (int i = 0; i < p.size(); i++) {
					pste.setObject(i + 1, p.get(i));
				}
			}

			rs = pste.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				@SuppressWarnings("deprecation")
				T entity = cls.newInstance();
				for (int j = 0; j < rsmd.getColumnCount(); j++) {
					String col_name = rsmd.getColumnName(j + 1);
					Object value = rs.getObject(col_name);
//					System.out.println(col_name);
//					if (col_name.equals("userId")) {
//						// 报错问题 Can not set java.lang.String field com.educoder.entity.User.userId to
//						// java.lang.Integer
//						value = (Integer) value;
//						System.out.println("qwe");
//					}
					Field field = cls.getDeclaredField(col_name);
					field.setAccessible(true);
//
					field.set(entity, value);
				}
				list.add(entity);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll(rs, pste, conn);
		}
		return list;
	}

	// 澶勭悊鏈夊涓粨鏋滈泦鐨勬煡璇�
	public static <T> List<T> operQueryHaveManyResultSet(String sql, List<Object> p, Class<T> cls) throws Exception {
		Connection conn = null;
		PreparedStatement pste = null;// 棰勫鐞嗚鍙�
		ResultSet rs = null;
		List<T> list = new ArrayList<T>();
		conn = getConn();
		boolean label = true;
		try {
			pste = conn.prepareStatement(sql);
			if (p != null) {
				for (int i = 0; i < p.size(); i++) {
					pste.setObject(i + 1, p.get(i));
				}
			}
			rs = pste.executeQuery();
			while (label) {
				int i = 0;
				i = pste.getUpdateCount();
				boolean up_label = false;
				if (i != -1) {
					up_label = pste.getMoreResults();
					continue;
				}
				boolean flag_label = false;
				rs = pste.getResultSet();
				if (rs != null) {
					ResultSetMetaData rsmd = rs.getMetaData();
					int columnCount = rsmd.getColumnCount();
					while (rs.next()) {
						@SuppressWarnings("deprecation")
						T entity = cls.newInstance();// 鍙嶅皠
						for (int j = 0; j < columnCount; j++) {
							String col_name = rsmd.getColumnName(j + 1);
							Object value = rs.getObject(col_name);
							Field field = cls.getDeclaredField(col_name);
							field.setAccessible(true);
							field.set(entity, value);
						}
						list.add(entity);
					}
					flag_label = pste.getMoreResults();
					continue;
				}
				label = up_label || flag_label;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			releaseAll(rs, pste, conn);
		}
		return list;
	}

	private static void releaseAll(ResultSet res, PreparedStatement pste, Connection conn) {
		try {
			if (res != null)
				res.close();
			if (pste != null)
				pste.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}