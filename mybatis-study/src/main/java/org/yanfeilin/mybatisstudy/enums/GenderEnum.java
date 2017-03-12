package org.yanfeilin.mybatisstudy.enums;


/**
 * 性别枚举
 * @author yanfeilin
 *
 */
public enum GenderEnum {
	MALE("男"),FEMALE("女");
	
	private String name;
	
	private GenderEnum(String name){
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
