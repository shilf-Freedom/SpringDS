package cn.freedom.springds.sm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.freedom.springds.pojo.User;

public class Test {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/cn/freedom/springds/sm/applicationContext.xml");
		
		UserMapper userMapper = context.getBean(UserMapper.class);
		RoleMapper roleMapper = context.getBean(RoleMapper.class);
		System.out.println(roleMapper.findRoleById(1).getRoleName());
		System.out.println(userMapper.findUserById(4).getUserName());
		
		User user = new User(5, "shi", "hahaha", "male", "19999999", "108@qq.com", "ycycyc");
		userMapper.deleteUser(5);
	}

}
