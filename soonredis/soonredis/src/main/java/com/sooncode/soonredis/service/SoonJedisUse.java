package com.sooncode.soonredis.service;

import redis.clients.jedis.Jedis;

public interface SoonJedisUse<M> {
	public  M use ( Jedis jedis );
}
