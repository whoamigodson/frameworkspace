package org.yanfeilin.mybatisstudy.mappers;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.yanfeilin.mybatisstudy.domain.User;

public interface UserMapper {
	
	List<User> selectAllUser();
	
	@Select(value="select n.u_id as id,n.u_name as username,"
			+ "n.u_pwd as password,n.u_nickname as nickname,"
			+ "n.u_type as type from t_user n where n.u_id = #{id}")
	User selectOneUser(Long id);
	
	void insertUser(User user);
	
	HashMap<String, Object> selectUserAsMap(Long id);
}
