package cn.freedom.springds.trans;

import cn.freedom.springds.pojo.Role;

public interface RoleService {
	
	public int insertRole(Role role);
	
	public int deleteRole(int id);
	
	public int updateRole(Role role);
	
	public Role findRoleById(int id);

}
