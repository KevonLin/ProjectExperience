package com.lin.utils;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author lin
 * @Descption 操作数据库的工具类
 * @date 2022/2/4 上午11:00
 */
public class JDBCUtils {
	public static Connection getConnection() throws Exception {
		// 读取配置文件
		InputStream is = ClassLoader.getSystemResourceAsStream("jdbc.properties");
		Properties pros = new Properties();
		pros.load(is);

		String user = pros.getProperty("user");
		String password = pros.getProperty("password");
		String url = pros.getProperty("url");
		String driverClass = pros.getProperty("driverClass");

		// 加载驱动
		Class.forName(driverClass);

		// 获取连接
		Connection conn = DriverManager.getConnection(url, user, password);

		return conn;
	}

	/**
	 * @param conn
	 * @param ps
	 * @Description 关闭链接和Statement的操作
	 */
	public static void closeResource(Connection conn, Statement ps) {
		// 资源关闭
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 资源关闭
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	public boolean isOnline() {
		String remoteInetAddr = "150.158.155.197";
		boolean reachable = false;
		try {
			InetAddress address = InetAddress.getByName(remoteInetAddr);
			reachable = address.isReachable(1000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return reachable;
	}

	public String getIPv4() {
		InetAddress ip4 = null;
		String str = null;
		try {
			ip4 = InetAddress.getLocalHost();
			str = ip4.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return str;
	}
}
