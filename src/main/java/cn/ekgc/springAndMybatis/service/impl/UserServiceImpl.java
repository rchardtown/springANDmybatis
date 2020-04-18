package cn.ekgc.springAndMybatis.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.ekgc.springAndMybatis.dao.UserDao;
import cn.ekgc.springAndMybatis.entity.User;
import cn.ekgc.springAndMybatis.service.UserService;

//因为UserServiceImpl 实在扫描包范围：base-package="cn.ekgc.springAndMybatis" 范围内
//所以 spring 会自动的完成：
//  @Service   <==>
//	<bean class="cn.ekgc.spring.introductionDemo.ioc.userDao.UserDaoImpl"></bean> 的创建
//  但是我们要使用这个 对象，需要知道它的标识是什么,需要一个  id="userService"
//  @Service("userService")   <==>
//	<bean id="userService"  class="cn.ekgc.spring.introductionDemo.ioc.userDao.UserDaoImpl"></bean>

@Service("userService") //用来创建对象
public class UserServiceImpl implements UserService {
	//<property name="userDao" ref="userDao" />
	// 首先 @Resource 是用依赖注入的
	// 其次，我们的userDao 对象必须有具体的赋值 :new UserDaoImpl()，不然报错：空指针异常
	//  这里用@Resource 的方式依赖注入
	//  底层原理：
	/**
	 * @Resource(name = "userDao")      <==>     <property  name="userDao" ref="userDao" />
	 *  		左边 ：   name：匹配： 右边 :  ref 
	 * 右边  ref ="userDao"  关联底层：
	 * <bean id="userDao" class="cn.ekgc.springAndMybatis.service.impl.UserDaoImpl"></bean>
	 *  的 id="userDao"  ,而这个 userDao，spring 默认为 接口UserDao 首字母小写的结果
	 *  
	 *  所以，@Resource（name="要依赖注入的实现类对应的接口首字母小写的结果"）
	 *  注解扫描的底层调用的还是 一个个<bean> </bean>
	 * 
	 */
	
	@Resource(name = "userDao") //用来创建对象userService依赖的对象
	private UserDao userDao;
	/**
	 * 至此完成了：
	 * <bean id="userService" class="cn.ekgc.springAndMybatis.service.impl.UseServiceImpl">
	 * 	<property name="dD"  ref ="userDao"/>
	 * </bean>
	 */
	
	@Override
	public boolean saveUser(User user) throws Exception {
		try {
			userDao.saveUser(user);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
}
