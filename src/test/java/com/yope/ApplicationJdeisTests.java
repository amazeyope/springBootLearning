package com.yope;

import com.yope.domain.User;
import com.yope.domain.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author yope
 * @version 1.0.0
 * @date 16/08/27 02:34.
 * @github https://github.com/amazeyope
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
public class ApplicationJdeisTests {
/*
* 注意：本测试用例初始化数据时
* @Configuration @EnableSwagger2 需要去掉 否则会抛异常
* */

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private RedisTemplate<String, User> redisTemplate;

	@Test
	public void test() throws Exception {

		// 保存字符串
		stringRedisTemplate.opsForValue().set("name", "yope");
		Assert.assertEquals("yope", stringRedisTemplate.opsForValue().get("name"));

		// 保存对象
		User user = new User("超人", 20);

		redisTemplate.opsForValue().set(user.getName(), user);

		user = new User("蝙蝠侠", 30);
		redisTemplate.opsForValue().set(user.getName(), user);

		user = new User("蜘蛛侠", 40);
		redisTemplate.opsForValue().set(user.getName(), user);

		Assert.assertEquals(20, redisTemplate.opsForValue().get("超人").getAge().longValue());
		Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
		Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

	}



}
