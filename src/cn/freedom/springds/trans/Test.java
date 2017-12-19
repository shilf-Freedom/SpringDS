package cn.freedom.springds.trans;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.freedom.springds.pojo.Role;

public class Test {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/cn/freedom/springds/trans/applicationContext.xml");
		
		RoleListService service = context.getBean(RoleListService.class);
		List<Role> roles = new ArrayList<>();
		int[] ids = {2,4,6};
		
//		roles.add(new Role(3, "Kandy", "a student"));
//		roles.add(new Role(9, "Ruay", "a teacher"));
//		int count = service.insertRoleList(roles);
		
		roles = service.findRoleById(ids);
		System.out.println(roles.get(0).getRoleName());
	}

}
