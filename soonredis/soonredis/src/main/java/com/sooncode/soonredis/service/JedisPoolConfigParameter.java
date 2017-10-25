package com.sooncode.soonredis.service;

/**
 * 连接池配置参数
 * @author hechenwe@gmail.com
 *
 */
public class JedisPoolConfigParameter {
	
	private String host;
	private Integer port;
	private String password;
	
	// 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
	private Boolean blockWhenExhausted;
	private Boolean jmxEnabled;
	private Integer maxIdle;
	private Integer maxTotal;
	private Integer maxWaitMillis;
	private Boolean testOnBorrow;
	private Integer timeout;
	
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getBlockWhenExhausted() {
		return blockWhenExhausted;
	}
	public void setBlockWhenExhausted(Boolean blockWhenExhausted) {
		this.blockWhenExhausted = blockWhenExhausted;
	}
	public Boolean getJmxEnabled() {
		return jmxEnabled;
	}
	public void setJmxEnabled(Boolean jmxEnabled) {
		this.jmxEnabled = jmxEnabled;
	}
	public Integer getMaxIdle() {
		return maxIdle;
	}
	public void setMaxIdle(Integer maxIdle) {
		this.maxIdle = maxIdle;
	}
	public Integer getMaxTotal() {
		return maxTotal;
	}
	public void setMaxTotal(Integer maxTotal) {
		this.maxTotal = maxTotal;
	}
	public Integer getMaxWaitMillis() {
		return maxWaitMillis;
	}
	public void setMaxWaitMillis(Integer maxWaitMillis) {
		this.maxWaitMillis = maxWaitMillis;
	}
	public Boolean getTestOnBorrow() {
		return testOnBorrow;
	}
	public void setTestOnBorrow(Boolean testOnBorrow) {
		this.testOnBorrow = testOnBorrow;
	}
	public Integer getTimeout() {
		return timeout;
	}
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}
	
	
	
}
