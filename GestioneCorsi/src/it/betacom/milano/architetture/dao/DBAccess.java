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
		try {
		ClassLoader cl = Thread.currentThread().getContextClassLoader();
		InputStream input = cl.getResourceAsStream("properties/config.properties");
		Properties p = new Properties();
		p.load(input);
		Class.forName(p.getProperty("jdbcDriver"));
		
			conn = DriverManager.getConnection(
					p.getProperty("jdbcUrl"), 
					p.getProperty("jdbcUsername"),
					p.getProperty("jdbcPassword"));
			conn.setAutoCommit(false);
		}catch(NullPointerException exc) {
			System.out.println("sono qui");
			System.out.println(exc.getMessage());			
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
