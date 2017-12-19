package cn.freedom.springds.sm;

import org.springframework.stereotype.Repository;

import cn.freedom.springds.pojo.User;

@Repository
public interface UserMapper {

	public int insertUser(User user);
	
	public int deleteUser(int id);
	
	public int updateUser(User user);
	
	public User findUserById(int id);
}
