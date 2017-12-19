package cn.freedom.springds.trans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.freedom.springds.mapper.RoleMapper;
import cn.freedom.springds.pojo.Role;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleMapper roleMapper = null;

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public int insertRole(Role role) {
		return roleMapper.insertRole(role);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public int deleteRole(int id) {
		return roleMapper.deleteRole(id);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public int updateRole(Role role) {
		return roleMapper.updateRole(role);
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.READ_COMMITTED)
	public Role findRoleById(int id) {
		return roleMapper.findRoleById(id);
	}

}
