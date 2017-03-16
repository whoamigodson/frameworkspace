package org.yanfeilin.mybatisstudy.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias(value="userGroup")
public class UserGroup implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private User user;
	
	private Group group;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}
	
}
