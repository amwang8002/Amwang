package com.amwang.temptest;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class JavaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String menuId = "9,8,6,4,2,1,41,23,21,44,42,24,22,45,43,61,63";
		String[] menu = menuId.split(",");
		
		List<String> result = Arrays.asList(menu);
		
		System.out.println(result.contains("9"));
		System.out.println(String.format("%s,%s,%s", menu));
		System.out.println(StringUtils.join(menu,",")); // 转为逗号分隔
		System.out.println(menuId.concat(",").concat("999"));
	}

}
