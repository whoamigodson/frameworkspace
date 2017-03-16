package org.yanfeilin.mybatisstudy;


import org.junit.Test;
import org.yanfeilin.mybatisstudy.utils.SerializeUtil;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTest {
	
	@Test
	public void test01() {
		//创建jedis客户端
		JedisPoolConfig config = new JedisPoolConfig();
		JedisPool pool = new JedisPool(config,"192.168.16.101");
		Jedis client = pool.getResource();
		client.set(SerializeUtil.serialize("hello"), 
				SerializeUtil.serialize("world"));
		String world = (String)SerializeUtil.unserialize(client.get(SerializeUtil.serialize("hello")));
		System.out.println(world);
	}
}
