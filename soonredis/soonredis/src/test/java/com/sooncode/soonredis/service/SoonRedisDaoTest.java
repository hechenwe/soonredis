package com.sooncode.soonredis.service;

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
	public void get (){
		String value = soonRedisDao.get("A");
		System.out.println("-----------------------:"+value);
	}
	 
}
