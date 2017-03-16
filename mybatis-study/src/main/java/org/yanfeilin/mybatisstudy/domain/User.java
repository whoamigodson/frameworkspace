package org.yanfeilin.mybatisstudy.domain;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;
import org.yanfeilin.mybatisstudy.enums.GenderEnum;
@Alias(value="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String username;
	
	private String password;
	
	private String nickname;
	
	private Short type;
	
	/**使用EnumOrdinalTypeHandler处理枚举类型*/
	private PhoneNumber phoneNumber;
	
	private GenderEnum gender;
	
	public User(){
		
	}
	
	public User(Long id){
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public PhoneNumber getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(PhoneNumber phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Short getType() {
		return type;
	}

	public void setType(Short type) {
		this.type = type;
	}
	
	
}
