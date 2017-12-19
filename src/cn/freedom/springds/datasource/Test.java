package cn.freedom.springds.datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cn.freedom.springds.pojo.Role;

public class Test {
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("/cn/freedom/springds/datasource/applicationContext.xml");
		JdbcTemplate template = context.getBean(JdbcTemplate.class);
		
		String sql = "select*from role where id=1";
		Role role = template.queryForObject(sql, new RowMapper<Role>() {
			@Override
			public Role mapRow(ResultSet rs, int arg1) throws SQLException {
				return new Role(rs.getInt("id"), rs.getString("roleName"), rs.getString("note"));
			}
		});
		
		role = new Role(3, "Joy", "fool");
		RoleDao dao = new RoleDao();
		List<Role> roles = dao.findRolesByRoleName(template, "Tom");
		role = dao.findRoleByStatementCallback(template, 1);
		dao.insertRole(template, role);
		dao.deleteRole(template, 3);
		role.setNote("hello everyone!!!");
		dao.updateRole(template, role);
		roles.get(0);
	}

}
