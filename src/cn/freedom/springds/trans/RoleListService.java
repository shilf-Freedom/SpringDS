package cn.freedom.springds.trans;

import java.util.List;

import cn.freedom.springds.pojo.Role;

public interface RoleListService {
	
	public int insertRoleList(List<Role> roles);
	
	public int deleteRole(int[] ids);
	
	public int updateRole(List<Role> roles);
	
	public List<Role> findRoleById(int[] ids);

}
