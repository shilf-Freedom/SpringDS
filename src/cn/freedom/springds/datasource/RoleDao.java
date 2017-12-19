package cn.freedom.springds.datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import cn.freedom.springds.pojo.Role;

public class RoleDao {
	
	public int insertRole(JdbcTemplate template, Role role) {
		String sql = "insert role value(?, ?, ?)";
		return template.update(sql, role.getId(), role.getRoleName(), role.getNote());
	}
	
	public int deleteRole(JdbcTemplate template, int id) {
		String sql = "delete from role where id = ?";
		return template.update(sql, id);
	}
	
	public int updateRole(JdbcTemplate template, Role role) {
		String sql = "update role set roleName = ?, note = ? where id = ?";
		return template.update(sql, role.getRoleName(), role.getNote(), role.getId());
	}
	
	public List<Role> findRolesByRoleName(JdbcTemplate template, String roleName){
		String sql = "select * from role where roleName like concat('%', ?, '%')";
		Object[] params = {roleName};
		List<Role> roles = template.query(sql, params, (ResultSet rs, int rowNum) -> {
			return new Role(rs.getInt("id"), rs.getString("roleName"), rs.getString("note"));
		});
		
		return roles;
	}
	
	public Role findRoleByConnectionCallback(JdbcTemplate template, int id) {
		Role role = null;
		
		role = template.execute((Connection con)->{
			Role result = null;
			String sql = "select * from role where id = ?";	
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				result = new Role(rs.getInt("id"), rs.getString("roleName"), rs.getString("note"));
				
			}
			return result;
		});

		return role;
	}
	
	public Role findRoleByStatementCallback(JdbcTemplate template, int id) {
		Role role = null;
		
		role = template.execute((Statement stmt)->{
			Role result = null;
			String sql = "select * from role where id = " + id;	
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				result = new Role(rs.getInt("id"), rs.getString("roleName"), rs.getString("note"));
				
			}
			return result;
		});

		return role;
	}
}
