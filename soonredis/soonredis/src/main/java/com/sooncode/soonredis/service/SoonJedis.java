package com.sooncode.soonredis.service;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class SoonJedis {
	private JedisPoolConfigParameter jedisPoolConfigParameter;

	private JedisPool jedisPool;
	 

	public void setJedisPoolConfigParameter(JedisPoolConfigParameter jedisPoolConfigParameter) {
		this.jedisPoolConfigParameter = jedisPoolConfigParameter;
		
		JedisPoolConfig config = new JedisPoolConfig();
        // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
        config.setBlockWhenExhausted(this.jedisPoolConfigParameter.getBlockWhenExhausted());
        // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
        config.setEvictionPolicyClassName("org.apache.commons.pool2.impl.DefaultEvictionPolicy");
        // 是否启用pool的jmx管理功能, 默认true
        config.setJmxEnabled(this.jedisPoolConfigParameter.getJmxEnabled());
        // 最大空闲连接数, 默认8个 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
        config.setMaxIdle(this.jedisPoolConfigParameter.getMaxIdle());
        // 最大连接数, 默认8个
        config.setMaxTotal(this.jedisPoolConfigParameter.getMaxTotal());
        // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
        config.setMaxWaitMillis(this.jedisPoolConfigParameter.getMaxWaitMillis());
        // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
        config.setTestOnBorrow(this.jedisPoolConfigParameter.getTestOnBorrow());
        this.jedisPool = new JedisPool(config, this.jedisPoolConfigParameter.getHost(), this.jedisPoolConfigParameter.getPort(), this.jedisPoolConfigParameter.getTimeout(), this.jedisPoolConfigParameter.getPassword());
		
	}

 
	
	
	public <M> M useJedis(SoonJedisUse<M> soonJedisUse){
		M m = null;
		Jedis jedis = this.jedisPool.getResource();
		m = soonJedisUse.use(jedis);
		if(jedis != null){
			jedis.close();
		}
		return m ;
		
	}
	
	
	
}
