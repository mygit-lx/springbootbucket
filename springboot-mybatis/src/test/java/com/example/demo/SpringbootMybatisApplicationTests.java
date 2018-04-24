package com.example.demo;

import com.example.dao.entity.User;
import com.example.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringbootMybatisApplicationTests.class);

	@Resource
	private UserService userService;

	@Test
	public void contextLoads() {
	}

	/**
	 * 测试增删改查
	 */
	@Test
	public void test(){
		User user = userService.findById(1);
		log.info("通过id获取user信息："+user.toString());

		user.setPassword("888888");
		userService.updateUser(user);

		User user1 = new User();
		user1.setUsername("xiaoxx");
		user1.setName("小星星");
		user1.setPassword("222222");
		user1.setPhone("13890907676");
		//userService.insertUser(user1);

		//userService.deleteUser(3);

		List<User> all = userService.findAll();
		log.info("所有用户信息："+all.toString());
	}
}
