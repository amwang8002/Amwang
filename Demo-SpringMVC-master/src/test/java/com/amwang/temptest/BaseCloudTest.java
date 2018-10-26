package com.amwang.temptest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.serverModel.dao.TbMenuMapper;
import com.amwang.biz.serverModel.entity.TbMenu;
import com.amwang.utils.JsonUtils;

public class BaseCloudTest extends AbstractSpringContextTestSupport {

	@Autowired
	private TbMenuMapper menuMapper;
	
	@Test
	public void tbMenuTest() {
		String menuId = "9,8,4,2,1,41,23,21,44,42,24,22,45,43,61,63,7,100";
		String[] menu = menuId.split(",");
		List<TbMenu> resultList = menuMapper.queryIdByParentId(null,menu);
		
		List<Integer> level1 = new ArrayList<>();
		List<Integer> level2 = new ArrayList<>();
		
		if (resultList.size() > 0) {
			// 拿到一级菜单
			List<Integer> addMenuId = new ArrayList<>();
			for (TbMenu tbMenu : resultList) {
				Integer parentId = tbMenu.getParentId();
				if (parentId == -1) {
					level1.add(tbMenu.getMenuId());
				}else {
					if (!Arrays.asList(menu).contains(parentId.toString())) {
						menuId = menuId.concat(",").concat(parentId.toString());
						menu = menuId.split(",");
					}
				} 
			}
			System.out.println(menuId);
			System.out.println(JsonUtils.list2JsonString(addMenuId));
			// 拿到二级菜单
			for (TbMenu tbMenu : resultList) {
				Integer parentId = tbMenu.getParentId();
				if (level1.contains(parentId)) {
					level2.add(tbMenu.getMenuId());
				}
			}
			
			System.out.println(JsonUtils.list2JsonString(level2));
		}
		
		List<Integer> dropSecMenu = new ArrayList<>();
		if (level2.size() > 0) {
			// 遍历每个二级菜单的三级菜单
			for (Integer integer : level2) {
				List<TbMenu> result = menuMapper.queryIdByParentId(integer.toString(), null);
				boolean flag = false;
				if (result.size() > 0) {
					for (TbMenu tbMenu : result) {
						Integer oriMenuId = tbMenu.getMenuId();
						if (Arrays.asList(menu).contains(oriMenuId.toString())) {
							flag = true;
							break;
						}
					}
				}
				System.out.println(JsonUtils.list2JsonString(result));
				if (!flag) {
					dropSecMenu.add(integer); //这个二级菜单下没有三级菜单
				}
			}
			// 如果dropSecMenu不为空，移除里面的二级菜单
			if (dropSecMenu.size() > 0) {
				for (Integer removeMenu : dropSecMenu) {
					menu = clearMenu(menu, removeMenu.toString());
				}
				
			}
			
			System.out.println("移除二级菜单前的数组："+menuId);
			System.out.println("移除二级菜单后的数组："+StringUtils.join(menu,","));
		}
		
	}
	
	@Test
	public void ArrayTest() {
		String menuId = "9,8,6,4,2,1,41,23,21,44,42,24,22,45,43,61,63";
		String[] menu = menuId.split(",");
		menu = clearMenu(menu, "63");
		System.out.println(StringUtils.join(menu,","));
	}
	
	private String[] clearMenu(String[] arr,String destValue) {
		int count = 0;	//定义一个变量记录0的个数
		for(int i = 0 ; i<arr.length ; i++){
			if(arr[i].equals(destValue)){
				count++;
			}
		}
 
		//创建一个新的数组
		String[] newArr = new String[arr.length-count];
			
		int index  =0 ; //新数组使用的索引值
		//把非的数据存储到新数组中。
		for(int i = 0; i<arr.length ; i++){
			if(!arr[i].equals(destValue)){
				newArr[index] = arr[i];
				index++;
			}
		}
		return newArr;

	}
}
