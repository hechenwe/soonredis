package com.sooncode.soonredis.service;

import java.util.Map;
import java.util.Map.Entry;

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
	public String mset(Map<String,String> keyAndValues) {
		
		if(keyAndValues==null || keyAndValues.size() == 0){
			return null;
		}
		
		return this.soonJedis.useJedis(new SoonJedisUse<String>() {
			
			@Override
			public String use(Jedis jedis) {
				String[] keyValues = new String[keyAndValues.size() * 2];
				int i = 0 ;
				for(Entry<String, String> en : keyAndValues.entrySet()){
					keyValues[i] = en.getKey();
					keyValues[i+1] = en.getValue();
					i = i+2;
				}
				
				return jedis.mset(keyValues);
			}
		});
		
	}

	public Long append(String key, String value) {

		return this.soonJedis.useJedis(new SoonJedisUse<Long>() {

			@Override
			public Long use(Jedis jedis) {
				return jedis.append(key, value);
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

	public Long del(String key) {

		return this.soonJedis.useJedis(new SoonJedisUse<Long>() {

			@Override
			public Long use(Jedis jedis) {

				return jedis.del(key);
			}
		});
	}

	public Long incr(String key) {

		return this.soonJedis.useJedis(new SoonJedisUse<Long>() {

			@Override
			public Long use(Jedis jedis) {

				return jedis.incr(key);
			}
		});
	}

}
