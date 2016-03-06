package com.tboys.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHelper {

	private static Connection conn;

	private static final String JDBC_DRIVER = "oracle.jdbc.OracleDriver";

	private static final String PASSWORD = "123456";

	//Э��: ip:�˿ں�:SID(���ݿ���)
	private static final String URL = "jdbc:oracle:thin:@192.168.191.1:1521:orcl";

	private static final String USER = "delivery";

	static {
		// ���ڷ����
		try {
			// ����ָ������(JDBC����)
			// �����˸����һ������
			// Class cls = Class.forName(JDBC_DRIVER);
			Class.forName(JDBC_DRIVER);
			// cls.getAnnotations();
			// cls.getDeclaredMethods();
			// cls.getConstructors();
			// cls.getDeclaredFields();

			// Object obj = cls.newInstance();
			// Method m = cls.getMethod("setDate", Long.class, String.class);
			// m.invoke(obj, 10, "22");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * ����һ���µ�����
	 * 
	 * @return ���ݿ�����
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException {

		Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
		
		return conn;
	}

	/**
	 * �ͷ���Դ �ر�����,�ͷ���Դ �ر�����,���, �����
	 * 
	 * @param connection
	 *            ���ݿ�����
	 * @param statement
	 *            SQL ���
	 * @param resultSet
	 *            �����
	 * @throws SQLException
	 *             SQL �쳣
	 */
	public static void close(
			ResultSet rs, 
			Statement stat, 
			Connection conn) throws SQLException {
		
		if (rs != null) {
			rs.close();
		}
		
		if (stat != null) {
			stat.close();
		}
		
		if (conn != null) {
			conn.close();
		}
	}
}
