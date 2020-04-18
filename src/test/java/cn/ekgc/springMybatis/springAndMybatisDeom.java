package cn.ekgc.springMybatis;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ekgc.springAndMybatis.entity.User;
import cn.ekgc.springAndMybatis.service.UserService;

public class springAndMybatisDeom {
	private static final String PATH = "applicationContext.xml";

	@Test
	public void testSave() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(PATH);
		UserService userSerivce = (UserService) applicationContext.getBean("userService");
		User user = new User("崔涛", "12313");
		userSerivce.saveUser(user);
		applicationContext.close();
	}
}
