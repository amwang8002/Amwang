package com.amwang.temptest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

import com.amwang.utils.JsonUtils;

public class JavaTest {

	public static void main(String[] args) throws Exception {
		List<String> list1 = new ArrayList<String>();
		List<String> list2 = new ArrayList<String>();
		for (int i = 0; i < 10; i++) {
			list1.add("test" + i);
			list2.add("test" + i*2);
		}
		System.out.println(JsonUtils.list2JsonString(list1));
		System.out.println(JsonUtils.list2JsonString(list2));
		
		System.out.println(equalList(list1, list2));
		
		
		
	}

	public static boolean equalList(List list1, List list2) {
		if (list1.size() != list2.size())
			return false;
		for (Object object : list1) {
			if (!list2.contains(object))
				return false;
		}
		return true;
	}
}
