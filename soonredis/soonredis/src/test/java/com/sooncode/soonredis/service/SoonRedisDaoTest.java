package com.sooncode.soonredis.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class SoonRedisDaoTest {

	@Autowired
	private SoonRedisDao soonRedisDao ;
	
	@Test
	public void set (){
		String key = soonRedisDao.set("A", "87879");
		System.out.println("-----------------------:"+key);
	}
	@Test
	public void append (){
		Long n = soonRedisDao.append("A", " hello  redis");
		System.out.println("-----------------------:"+n);
	}
	@Test
	public void get (){
		String value = soonRedisDao.get("id");
		System.out.println("-----------------------:"+value);
	}
	@Test
	public void del (){
		Long n  = soonRedisDao.del("A");
		System.out.println("-----------------------:"+n);
	}
	@Test
	public void incr (){
		Long n  = soonRedisDao.incr ("id");
		System.out.println("-----------------------:"+n);
	}
	
	
	@Test
	public void mset (){
		Map<String,String> map = new HashMap<>();
		map.put("name", "hechen");
		map.put("id", "1");
		map.put("age", "20");
		String n  = soonRedisDao.mset(map);
		System.out.println("-----------------------:"+n);
	}
	 
}
