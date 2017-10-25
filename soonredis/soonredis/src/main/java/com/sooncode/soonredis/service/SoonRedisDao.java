package com.sooncode.soonredis.service;

import redis.clients.jedis.Jedis;

public class SoonRedisDao {
	private SoonJedis soonJedis;

	public SoonJedis getSoonJedis() {
		return this.soonJedis;
	}
	
	
	public void setSoonJedis(SoonJedis soonJedis) {
		this.soonJedis = soonJedis;
	}



	public String set(String key, String value) {

		return this.soonJedis.useJedis(new SoonJedisUse<String>() {

			@Override
			public String use(Jedis jedis) {
				return jedis.set(key, value);
			}
		});

	}

	public String get(String key) {

		return this.soonJedis.useJedis(new SoonJedisUse<String>() {

			@Override
			public String use(Jedis jedis) {

				return jedis.get(key);
			}
		});
	}
	
	
}
