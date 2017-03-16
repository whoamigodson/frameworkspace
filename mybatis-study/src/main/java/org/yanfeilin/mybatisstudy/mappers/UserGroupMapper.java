package org.yanfeilin.mybatisstudy.mappers;

import java.util.List;

import org.yanfeilin.mybatisstudy.domain.UserGroup;

public interface UserGroupMapper {
	
	public void insert(UserGroup userGroup);
	
	public UserGroup findOne(Long id);
	
	public List<UserGroup> findAllList();
	
	public void delete(Long id);
}
