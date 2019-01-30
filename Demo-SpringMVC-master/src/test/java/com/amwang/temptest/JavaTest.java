package com.amwang.temptest;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.ArrayList;
import java.util.List;

public class JavaTest {

	public static void main(String[] args) throws Exception {
		List<Integer> record = new ArrayList<Integer>();
		
		record.add(1);
		record.add(2);
		record.add(3);
		record.add(51);
		
		record.contains(4);
		System.out.println(record.get(0).toString()+record.get(3).toString());
		System.out.println(record.contains(4));

	}
}
