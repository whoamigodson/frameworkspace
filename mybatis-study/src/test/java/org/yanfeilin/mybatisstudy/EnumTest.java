package org.yanfeilin.mybatisstudy;

import static org.junit.Assert.assertNotNull;

import java.util.EnumMap;
import java.util.EnumSet;

import org.junit.Test;
import org.yanfeilin.mybatisstudy.enums.GenderEnum;

public class EnumTest {
	
	@Test
	public void testGetEnumOrdinals() {
		Enum<GenderEnum>[] enums = GenderEnum.values();
		if(enums != null && enums.length > 0){
			for(Enum<GenderEnum> e : enums){
				System.out.println(e.ordinal()+","+e.name());
			}
		}
	}
	
	@Test
	public void testEnumSet() {
		EnumSet<GenderEnum> set = EnumSet.allOf(GenderEnum.class);
		assertNotNull(set);
		for(GenderEnum genderEnum : set){
			System.out.println(genderEnum.ordinal()+","+genderEnum.getName());
		}
	}
	
	@Test
	public void testEnumMap() {
		EnumMap<GenderEnum, String> map = new 
				EnumMap<GenderEnum, String>(GenderEnum.class);
		map.put(GenderEnum.FEMALE, GenderEnum.FEMALE.getName());
		map.put(GenderEnum.MALE, GenderEnum.MALE.getName());
		System.out.println(map);
	}
	
	@Test
	public void testEnumGetValue() {
		System.out.println(GenderEnum.MALE.getName());
	}
	
}
