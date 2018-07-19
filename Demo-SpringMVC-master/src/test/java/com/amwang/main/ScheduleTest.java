package com.amwang.main;

import java.io.IOException;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.biz.job.ScheduleJob;
import com.amwang.biz.serverModel.dao.TbeisaiDataDao;
import com.amwang.biz.serverModel.entity.TbeisaiData;
import com.amwang.biz.service.MyserverGetDataService;
import com.amwang.utils.DateUtil;
import com.amwang.utils.JsonUtils;

public class ScheduleTest extends AbstractSpringContextTestSupport {

	@Autowired
	private MyserverGetDataService service;
	@Autowired
	private ScheduleJob schedulejob;
	@Autowired
	private TbeisaiDataDao dao;
	@Test
	public void testGetData() throws IOException{
//		schedulejob.getData();
		service.sumNums("2018-07-18");
	}
	
	@Test
	public void testUpd() {
		List<TbeisaiData> result = dao.sumNums(DateUtil.getCurrentDate());
		String arr[][] = new String[10][10];
		if (!CollectionUtils.isEmpty(result) && result.size() > 5) {
			for (int i = 0; i < result.size(); i++) {
				TbeisaiData record = result.get(i);
				arr[0][i]  = record.getNum1(); 
				arr[1][i]  = record.getNum2(); 
				arr[2][i]  = record.getNum3(); 
				arr[3][i]  = record.getNum4(); 
				arr[4][i]  = record.getNum5(); 
				arr[5][i]  = record.getNum6(); 
				arr[6][i]  = record.getNum7(); 
				arr[7][i]  = record.getNum8(); 
				arr[8][i]  = record.getNum9(); 
				arr[9][i]  = record.getNum10();
			}
		}
		
		System.out.println(JsonUtils.obj2JsonString(arr));
		
		int h = 0;
		for (String[] strings : arr) {
			System.err.println(strings.length);
			int i = 0; //偶数
			int f = 0; //奇数
			int s = 0; //小
			int b = 0; //大
			for (String string : strings) {
				System.out.println(h);
				int a = Integer.valueOf(string);
				if (a%2 == 0) {
					i++;
				} else {
					f++;
				}
				
				if (i == 10) {
					//全是偶数
					System.out.println("全是偶数"+h);
				}
				if (f == 10) {
					//全是奇数
					System.out.println("全是奇数"+h);
				}
				
				if (0 < a && a < 6) {
					s++;
				} else {
					b++;
				}
				
				if (s == 10) {
					//全是小
					System.out.println("全是小"+h);
				} 
				if (b == 10) {
					//全是大
					System.out.println("全是大"+h);
				}
			}
			h++;
		}
	}
}
