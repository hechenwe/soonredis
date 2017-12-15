package com.sooncode.soonredis.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;
	
	@Test
	public void save() {
		Order o = new Order();
		o.setId("123324");
		orderDao.save(o);
		
		Order newO = orderDao.read("123324");
		System.out.println(newO);
		
	}
}
