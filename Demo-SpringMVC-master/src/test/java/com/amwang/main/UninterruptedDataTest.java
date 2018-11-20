package com.amwang.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.entity.TDataUnterruptedCounts;
import com.amwang.biz.service.SumEveryDataCountsService;
import com.amwang.utils.JsonUtils;

public class UninterruptedDataTest extends AbstractSpringContextTestSupport {

	@Autowired
	private SumEveryDataCountsService sumEveryDataCountsService;
	
	@Test
	public void unterruptedDataTest() {
		List<TDataUnterruptedCounts> result = sumEveryDataCountsService.queryByCondition();
		System.err.println(JsonUtils.list2JsonString(result));
	}
	
	@Test
	public void testArray() {
		int [][] sequences = new int[10][4];
		int [] counts = new int [30];
		
		for (int i = 0; i < 5; i++) {
			sequences[1][1]++;
			sequences[2][1]++;
			
			counts[3]++;
		}
		
		System.out.println(JsonUtils.obj2JsonString(sequences));
		System.out.println(JsonUtils.obj2JsonString(counts).replace("[", "").replace("]", "").replace("\"", ""));
		sequences[1][1] = 0;
		System.out.println(JsonUtils.obj2JsonString(sequences));
	}
	
	@Test
	public void testOrder() {
		List<Integer> result = getOrder(0, 0, null);
		System.out.println(result);
	}
	
	private List<Integer> getOrder(int numOfOrders,int size, List<Integer> orders){
		List<Integer> resultOrder = new ArrayList<Integer>();
		
		for (int i = 0; i < orders.size()-(size-1); i++) {
			int result = 0;
			result = orders.get(i) < 0 ? orders.get(i):0;
			if (result == 0) {
				result = orders.get(i+1) < 0 ? orders.get(i+1):0;
			}
			if (result == 0) {
				result = orders.get(i+2) < 0 ? orders.get(i+2):0;
			}
			resultOrder.add(result);
			
		}
		
		return resultOrder;
	}
	
	@Test
	public void compareList() {
	
		List<Integer> menuId = new ArrayList<Integer>();
		List<Integer> resource = new ArrayList<Integer>();
		
		menuId.add(1);
		menuId.add(2);
		menuId.add(4);
		menuId.add(21);
		menuId.add(22);
		menuId.add(23);
		
		resource.add(1);
		resource.add(2);
		resource.add(4);
		resource.add(31);
		resource.add(32);
		resource.add(21);
		resource.add(22);
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>(resource.size());
		List<Integer> diffList = new ArrayList<Integer>();
		
		for (Integer resourcenode : resource) {
			map.put(resourcenode, 1);
		}
		for (Integer menu : menuId) {
			if (map.get(menu) == null) {
				diffList.add(menu);
			}
		}
		System.out.println(JsonUtils.list2JsonString(resource));
		diffList.clear();
		System.out.println(diffList.size());
		Map<Integer, Integer> menuMap = new HashMap<Integer, Integer>(menuId.size());
		for (Integer menu : menuId) {
			menuMap.put(menu, 1);
		}
		for (Integer res : resource) {
			if (menuMap.get(res) == null) {
				diffList.add(res);
			}
		}
//		System.out.println("resource 中有，menu中无");
//		System.out.println(JsonUtils.list2JsonString(diffList));
		
	}
	
}
