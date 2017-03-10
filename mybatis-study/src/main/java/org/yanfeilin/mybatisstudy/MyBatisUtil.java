package org.yanfeilin.mybatisstudy;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static final SqlSessionFactory sessionFactory = buildFactory();
	
	private static SqlSessionFactory buildFactory() {
		if(sessionFactory==null){//当sessionFactory为空时创建SqlSessionFactory
			String resource="org/yanfeilin/mybatisstudy/mybatis-config.xml";
			try {
				InputStream inputStream = Resources.getResourceAsStream(MyBatisUtil.class
						.getClassLoader(),resource);
				SqlSessionFactory ssf=new SqlSessionFactoryBuilder().build(inputStream);
				return ssf;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;//不为空时直接返回SqlSessionFactory
	}
	
	public static SqlSession openSession() {
		return sessionFactory.openSession();
	}
	
	public static void closeSession(SqlSession s) {
		if(s!=null) s.close();
	}
}
