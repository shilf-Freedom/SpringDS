package cn.freedom.springds.mapper;

import cn.freedom.springds.pojo.Role;

public interface RoleMapper {

	public int insertRole(Role role);
	
	public int deleteRole(int id);
	
	public int updateRole(Role role);
	
	public Role findRoleById(int id);
}
