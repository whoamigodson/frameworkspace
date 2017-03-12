package org.yanfeilin.mybatisstudy;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yanfeilin.mybatisstudy.domain.PhoneNumber;
import org.yanfeilin.mybatisstudy.domain.User;
import org.yanfeilin.mybatisstudy.enums.GenderEnum;
import org.yanfeilin.mybatisstudy.mappers.UserMapper;

public class MybatisTest {
	
	private static final Logger LOG = LoggerFactory.getLogger(MybatisTest.class);
	
	private static SqlSession sqlSession = null;
	
	@Before
	public void init() {
		sqlSession = MyBatisUtil.openSession();
	}
	
	@Test
	public void testSelectOne() {
		User user = (User)sqlSession.selectOne(
				"org.yanfeilin.mybatisstudy.mappers.UserMapper.selectUser", 6);
		assertNotNull(user);
		
		LOG.info(user.getId()+","+user.getUsername()+","
		+user.getNickname()+","+
				(user.getPhoneNumber() != null ? user.getPhoneNumber().getAsString() : "")+","+
				(user.getGender() != null ? user.getGender().getName() : ""));
	}
	
	@Test
	public void testSelectOneByMapper() {
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		User user = mapper.selectOneUser(Long.valueOf(4));
		assertNotNull(user);
		System.out.println(user.getId()+","+user.getUsername()+","
		+user.getNickname()+","+
				(user.getPhoneNumber() != null ? user.getPhoneNumber().getAsString() : ""));
	}
	
	@Test
	public void testInsertUser() {
		try{
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("zhubajie");
		user.setPassword("********************");
		user.setNickname("猪八戒");
		user.setType(Short.valueOf("2"));
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setCountryCode("0731");
		phoneNumber.setStateCode("001");
		phoneNumber.setNumber("437284780");
		System.out.println(phoneNumber.getAsString());
		user.setPhoneNumber(phoneNumber);
		userMapper.insertUser(user);
		sqlSession.commit();
		assertNotNull(user.getId());
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	@Test
	public void testInsertUser1() {
		try{
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("shaheshang");
		user.setPassword("********************");
		user.setNickname("沙和尚");
		user.setType(Short.valueOf("1"));
		PhoneNumber phoneNumber = new PhoneNumber();
		phoneNumber.setCountryCode("0731");
		phoneNumber.setStateCode("001");
		phoneNumber.setNumber("437284780");
		System.out.println(phoneNumber.getAsString());
		user.setPhoneNumber(phoneNumber);
		user.setGender(GenderEnum.MALE);
		userMapper.insertUser(user);
		sqlSession.commit();
		assertNotNull(user.getId());
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}
	}
	
	@Test
	public void testFindAllList() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> users = userMapper.selectAllUser();
		assertNotNull(users);
		assertNotEquals(0,users.size());
		for(User user : users){
			System.out.println(user.getId()+","+user.getUsername()+","
					+user.getNickname()+","+
					(user.getPhoneNumber() != null ? user.getPhoneNumber().getAsString() :""));
		}
	}
	
	@Test
	public void testSelectUserAsMap() {
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		HashMap<String, Object> map = userMapper.selectUserAsMap(Long.valueOf(6));
		System.out.println(map);
	}
	
	@After
	public void destory() {
		MyBatisUtil.closeSession(sqlSession);
	}
}
