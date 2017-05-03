package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

	public static Properties pop = null;

	public DBUtils() {
		initProperties();
	}

	/**
	 * ��ʼ�����������ļ�db/properties ���ڶ�ȡ�����ļ���� driver url user pwd
	 */
	public void initProperties() {
		pop = new Properties();
		InputStream in = this.getClass().getResourceAsStream("/db.properties");
		try {
			pop.load(in);
		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * ��������
	 * 
	 * @return ���Ӷ���
	 */
	public Connection getConn() {
		Connection conn = null;
		try {
			// ��������
			Class.forName(pop.getProperty("driver"));
			// ��������
			conn = DriverManager.getConnection(pop.getProperty("url"),
					pop.getProperty("user"), pop.getProperty("pwd"));

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * �ر�������Դ
	 * 
	 * @param rs
	 *            �����
	 * @param pst
	 *            �������
	 * @param conn
	 *            ���Ӷ���
	 */
	public void closeAll(ResultSet rs, PreparedStatement pst, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ִ������ɾ���ġ�
	 * 
	 * @param sql
	 *            sql�������
	 * @param obj
	 *            ��̬����
	 * @return
	 */
	public int executeUpdate(String sql, Object... obj) {
		int result = 0;
		Connection conn = getConn();
		PreparedStatement pst = null;
		try {
			pst = conn.prepareStatement(sql);
			// ����SQL����������
			if (obj.length > 0) {
				for (int i = 0; i < obj.length; i++) {
					pst.setObject((i + 1), obj[i]);
				}
			}
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeAll(null, pst, conn);
		}
		return result;
	}

}