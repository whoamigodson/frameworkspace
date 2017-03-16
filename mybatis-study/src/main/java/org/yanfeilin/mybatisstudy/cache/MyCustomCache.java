package org.yanfeilin.mybatisstudy.cache;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yanfeilin.mybatisstudy.utils.SerializeUtil;

import com.mysql.jdbc.StringUtils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 自定义mybatis缓存
 * @author yanfeilin
 *
 */
public class MyCustomCache implements Cache {
	
	private static Logger logger = LoggerFactory.getLogger(MyCustomCache.class);
    private static final Jedis redisClient = createClient();
    /** The ReadWriteLock. */
    private static final ReadWriteLock readWriteLock = 
    		new ReentrantReadWriteLock();
	private String id;
	
	public MyCustomCache() {

	}
	
	public MyCustomCache(String id) {
		if(StringUtils.isNullOrEmpty(id)){
			new RuntimeException("id不能为空！");
		}
		this.id = id;
	}
	
    protected static Jedis createClient() {
        try {
            JedisPool pool = new JedisPool(new JedisPoolConfig(),
                    "192.168.16.101");
            return pool.getResource();
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("初始化连接池错误");
    }
    
    public void setId(String id) {
		this.id = id;
	}
    
	@Override
	public String getId() {
		return this.id;
	}
	
	@Override
	public void putObject(Object key, Object value) {
		logger.debug("set key:"+key);
		redisClient.set(SerializeUtil.serialize(key), 
				SerializeUtil.serialize(value));
	}

	@Override
	public Object getObject(Object key) {
		logger.debug("get key:"+key);
		return redisClient.get(SerializeUtil.serialize(key));
	}

	@Override
	public Object removeObject(Object key) {
		logger.debug("get key:"+key);
		return redisClient.expire(SerializeUtil.serialize(key), 0);
	}

	@Override
	public void clear() {
		redisClient.flushDB();
	}

	@Override
	public int getSize() {
		return redisClient.dbSize().intValue();
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return readWriteLock;
	}

}
