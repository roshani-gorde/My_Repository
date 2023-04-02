package com.ashokit.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {
	private static DataSource ds = null;

	public static Connection getDBConnection() throws Exception {
		
			if (ds == null) {
				File f = new File("F:\\AshokIt\\STS-Workspace\\SERVLET\\BookDataInsert\\db.properties");
				FileInputStream fis = new FileInputStream(f);

				Properties p = new Properties();
				p.load(fis);

				String url = p.getProperty("db.url");
				String username = p.getProperty("db.username");
				String pwd = p.getProperty("db.pwd");
				String driver = p.getProperty("db.driver");

				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(url);
				config.setUsername(username);
				config.setPassword(pwd);
				config.setDriverClassName(driver);

				ds = new HikariDataSource(config);
			}
		
		Connection conn = ds.getConnection();
		return conn;

	}

}
