package com.hlsfile.utils;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**   
 * @ClassName:  RedisUtils   
 * @Description:TODO(Redis操作工具类)   
 * @author: hucheng 
 * @date:   2019年11月25日 上午11:29:46       
 * @Copyright: 2019 www.xxxx.com Inc. All rights reserved. 
 * 注意：本内容仅限于xxxxxxxxx传阅，禁止外泄以及用于其他的商业目
*/  
@Component
public class RedisUtils {
	/*
	RedisTemplate中定义了5种数据结构操作
	redisTemplate.opsForValue();//操作字符串
	redisTemplate.opsForHash();//操作hash
	redisTemplate.opsForList();//操作list
	redisTemplate.opsForSet();//操作set
	redisTemplate.opsForZSet();//操作有序set
	
	StringRedisTemplate与RedisTemple
	1.前者集成后者
	2.数据不共通的。即StringRedisTemplate只能管理StringRedisTemplate里面的数据，RedisTemplate只能管理RedisTemplate中的数据
	3.SDR默认采用的序列化有两种。一种是String的序列化策略，一种是JDK的序列化策略；
	4.StringRedisTemplate默认采用的是String 的序列化策略，保存的key和value都是采用的该策略序列化并保存的
	5.RedisTemplate默认采用的是JDK的序列化策略，保存的 key和value都是采用此策略序列化并保存的
	*/
	
	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	@Resource
	private StringRedisTemplate redisTemplate1;
	
    //操作字符
	/**
	 * 读取缓存
	 * 
	 * @param key
	 * @return
	 */
	public String get(final String key) {
		return redisTemplate.opsForValue().get(key);
	}
 
	/**
	 * 写入缓存
	 */
	public boolean set(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().set(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
 
	/**
	 * 更新缓存
	 */
	public boolean getAndSet(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForValue().getAndSet(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
 
	/**
	 * 删除缓存
	 */
	public boolean delete(final String key) {
		boolean result = false;
		try {
			redisTemplate.delete(key);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//操作list
	/**
	 * 写入缓存(单个)
	 */
	public boolean setlist(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForList().leftPush(key, value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 写入缓存(集合)
	 */
	public boolean setlists(final String key, List list) {
		boolean result = false;
		try {
			redisTemplate.opsForList().leftPushAll(key, list);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 删除缓存
	 */
	public boolean dellist(final String key, String value) {
		boolean result = false;
		try {
			redisTemplate.opsForList().remove(key,0,value);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}
