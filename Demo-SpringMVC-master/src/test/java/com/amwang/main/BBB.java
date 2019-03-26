package com.amwang.main;

import java.util.regex.Pattern;

public class BBB {

	public static void main(String[] args) {
		
		final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
    	final String REGEX_MOBILE = "^((17[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    	
    	String id = "1893736792d6@qq.com";
    	
    	if (!Pattern.matches(REGEX_MOBILE, id) || !Pattern.matches(REGEX_EMAIL, id)) {
			System.out.println("×-->"+id);
		}
    	if (!Pattern.matches(REGEX_MOBILE, id)) {
			if (!Pattern.matches(REGEX_EMAIL, id)) {
				System.out.println("既不是手机也不是邮箱-->"+id);
			}
		}
	}
	
	static class AA{
		String name ;
		String age;
		String gender;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAge() {
			return age;
		}
		public void setAge(String age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		
	}

}
