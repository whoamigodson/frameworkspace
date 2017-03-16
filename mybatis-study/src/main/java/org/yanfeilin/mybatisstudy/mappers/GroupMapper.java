package org.yanfeilin.mybatisstudy.mappers;

import java.util.List;

import org.yanfeilin.mybatisstudy.domain.Group;

public interface GroupMapper {
	
	public void insert(Group group);
	
	public Group findOne(Long id);
	
	public List<Group> findAllList();
	
	public void delete(Long id);
}
