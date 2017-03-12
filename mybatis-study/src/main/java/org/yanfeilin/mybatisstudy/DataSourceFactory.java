package org.yanfeilin.mybatisstudy;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.datasource.pooled.PooledDataSource;

/**
 * 获取数据源
 * @author yanfeilin
 *
 */
public class DataSourceFactory 
{
	private static final Properties PROPERTIES = new Properties();
	
	static
	{
		try {
			InputStream is = DataSourceFactory.class.getResourceAsStream("/db.properties");
			PROPERTIES.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource() 
	{
		String driver = PROPERTIES.getProperty("jdbc.driverClassName");
		String url = PROPERTIES.getProperty("jdbc.url");
		String username = PROPERTIES.getProperty("jdbc.username");
		String password = PROPERTIES.getProperty("jdbc.password");
		PooledDataSource dataSource = new PooledDataSource(driver, url, username, password);
		return dataSource;
	}
	
	public static DataSource getJNDIDataSource() 
	{
		String dataSourceJNDIName = "java:comp/env/jdbc/mybatisDs";
		try 
		{
			InitialContext ctx = new InitialContext();
			DataSource dataSource = (DataSource) ctx.lookup(dataSourceJNDIName);
			return dataSource;
		} 
		catch (NamingException e) 
		{
			throw new RuntimeException(e);
		}
	}
}
