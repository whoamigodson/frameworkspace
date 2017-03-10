package org.yanfeilin.mybatisstudy;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yanfeilin.mybatisstudy.domain.User;

public class MybatisTest {

	private static SqlSession sqlSession = null;
	
	@Before
	public void init() {
		sqlSession = MyBatisUtil.openSession();
	}
	
	@Test
	public void testSelectOne() {
		User user = (User)sqlSession.selectOne(
				"org.yanfeilin.mybatisstudy.domain.UserMapper.selectUser", 1);
		assertNotNull(user);
		
		System.out.println(user.getId()+","+user.getUsername()+","
		+user.getNickname());
	}
	
	@After
	public void destory() {
		MyBatisUtil.closeSession(sqlSession);
	}
}
