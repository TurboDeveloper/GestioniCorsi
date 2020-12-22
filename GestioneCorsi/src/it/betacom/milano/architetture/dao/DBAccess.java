package it.betacom.milano.architetture.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBAccess {
	static private Connection conn;

	public static synchronized Connection getConnection() throws IOException, DAOException, ClassNotFoundException {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream input = cl.getResourceAsStream("properties/config.properties");
		Properties p = new Properties();
		p.load(input);
		Class.forName(p.getProperty("JdbcDriver"));
		try {
			conn = DriverManager.getConnection(
					p.getProperty("jdbcUrl"), 
					p.getProperty("JdbcUsername"),
					p.getProperty("JdbcPassword"));
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return conn;

	}

	public static void closeConnection() throws SQLException {
		if (conn != null)
			conn.close();
	}

}
