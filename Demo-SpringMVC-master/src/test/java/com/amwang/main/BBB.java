package com.amwang.main;

import com.amwang.utils.JsonUtils;

public class BBB {

	public static void main(String[] args) {
		
		String[] product = new String[] {"1","1","0"};
		int length = product.length;
		int count = 0;
		for (int i = 1; i < length; i++) {
			String pro = product[i];
			if (pro.equals("0")) {
				count++;
			}
		}
		System.out.println(count);
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
