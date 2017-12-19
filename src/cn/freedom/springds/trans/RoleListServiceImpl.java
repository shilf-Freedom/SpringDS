package cn.freedom.springds.trans;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.freedom.springds.pojo.Role;

@Service
public class RoleListServiceImpl implements RoleListService {
	
	@Autowired
	private RoleService roleService = null;
	
	Logger log = Logger.getLogger(RoleListServiceImpl.class);
	
	@Override
	public int insertRoleList(List<Role> roles) {
		int count = 0;
		for(Role r : roles) {
			try {
				count += roleService.insertRole(r);
			} catch (Exception e) {
				log.info(e);
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int deleteRole(int[] ids) {
		int count = 0;
		for(int i = 0; i < ids.length; i++) {
			try {
				count += roleService.deleteRole(ids[i]);
			} catch (Exception e) {
				log.info(e);
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public int updateRole(List<Role> roles) {
		int count = 0;
		for(Role r : roles) {
			try {
				count += roleService.updateRole(r);
			} catch (Exception e) {
				log.info(e);
				e.printStackTrace();
			}
		}
		return count;
	}

	@Override
	public List<Role> findRoleById(int[] ids) {
		List<Role> roles = new ArrayList<>();
		for(int i = 0; i < ids.length; i++) {
			try {
				roles.add(roleService.findRoleById(ids[i]));
			} catch (Exception e) {
				log.info(e);
				e.printStackTrace();
			}
		}
		return roles;
	}
}
