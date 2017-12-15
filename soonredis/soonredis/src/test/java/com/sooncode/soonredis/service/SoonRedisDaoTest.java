package com.sooncode.soonredis.service;

 

import static org.junit.Assert.assertEquals;

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
		assertEquals("OK", key);//Junit 判断是否相等
		soonRedisDao.del("A");
		
	}
	@Test
	public void get (){
		soonRedisDao.set("A", "87879");
		String value = soonRedisDao.get("A");
		soonRedisDao.del("A");
		assertEquals("87879",value);
		 
	}
	@Test
	public void append (){
		soonRedisDao.set("A", "87879");
		long n = soonRedisDao.append("A", "14690");
		System.out.println("SoonRedisDaoTest.append()"+n);
		soonRedisDao.del("A");
		assertEquals(10L, n);
	}
	
	@Test
	public void del (){
		soonRedisDao.set("A", "87879");
		long n  = soonRedisDao.del("A");
		assertEquals(1L,n);
	}
	@Test
	public void incr (){
		soonRedisDao.set("id", "1");
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
