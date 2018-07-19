package com.amwang.main;

import com.amwang.utils.JsonUtils;

public class BBB {

	public static void main(String[] args) {
		
		System.out.println(0%2);
		int j = 0;
		for (int i = 0; i <10; i++) {
			j++;
		}
		System.err.println(j);
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
