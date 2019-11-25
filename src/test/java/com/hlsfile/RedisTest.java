package com.hlsfile;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hlsfile.utils.RedisUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {
	@Resource
	private RedisUtils redisUtils;
   
	//操作字符
	/**
	 * 插入缓存数据
	 */
	@Test
	public void set() {
		redisUtils.set("redis_key", "redis_vale");
		redisUtils.set("hu", "huang");
	}
	
	/**
	 * 读取缓存数据
	 */
	@Test
	public void get() {
		String value = redisUtils.get("redis_key");
		System.out.println(value);
	}
	
	/**
	 * 删除缓存数据
	 */
	@Test
	public void del() {
		String key = redisUtils.get("redis_key");
      if (key!=null) {
    	  boolean b = redisUtils.delete("redis_key");
  		if (b) {
  			System.out.println("redis数据清除成功!");
  		} else {
  			System.out.println("redis数据清除失败!");
  		}
	} else {
		  System.out.println("redis中没有该数据!");
	}
		
	}
	
	/**
	 * 更新缓存数据
	 */
	@Test
	public void update() {
		boolean b = redisUtils.getAndSet("redis_key","更新完后的缓存数据!");
		if (b) {
			System.out.println("redis数据更新成功!");
		} else {
			System.out.println("redis数据更新失败!");
		}
	}
	
	    //操作list
	     @Test
		public void setList() {
		/*redisUtils.setlist("list", "123");
		redisUtils.setlist("list", "456");
		redisUtils.setlist("list", "789");
	    	 ArrayList list = new ArrayList();
	    	 list.add("a");
	    	 list.add("b");
	    	 list.add("c");
	    	 redisUtils.setlists("lists", list);
	    */
	     redisUtils.delete("list");
		}
}
