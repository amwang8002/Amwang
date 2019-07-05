/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年6月11日  
* @version 1.0  
*/ 
package com.amwang.leetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCodeRun {

	public static void main(String[] args) {

	
		run( 1, 3, 3, 3, 2, 2, 2, 3, 1, 8, 5, 9, 1, 5, 6, 2,3, 8, 8, 5, 9 );
		run( 1, 3, 3, 3, 2, 2, 2, 3, 1, 8, 5, 9, 1, 5, 6,  9 );
		run( 1, 3, 3, 3, 2, 2, 2, 3, 1 );
		run( 8, 5, 9, 1, 5, 6, 2, 3, 8, 8, 5, 9);
	}
	
	private static void run(Integer... source) {
		System.out.println(new LeetCodeRun().rmRepeatNum(source));
	}

	private List<Integer> rmRepeatNum(Integer[] array) {

		// 结果字符串
		List<Integer> result = new ArrayList<Integer>();
		// 临时字符串，用来存放数组中超过三个的字符
		List<Integer> tempBuffer = new ArrayList<Integer>();

		for (int i = 0; i < array.length; i++) {
			// 原始数组中字符个数标识初始化，默认为1个
			int sign = 1;

			Integer ori = array[i];
			// 如果临时字符串不为空或者字符中包含当前要比较的字，跳过本次比较继续循环
			if (tempBuffer.size() > 0 && tempBuffer.contains(ori)) {
				continue;
			}
			// 遍历被比较数组
			for (int j = 0; j < array.length; j++) {

				// 如果个数已经超过2个，则结束当前循环
				if (sign > 2) {
					break;
				}

				// 比较字符与被比较字符重合了，跳过
				if (i == j) {
					continue;
				} else {
					Integer dest = array[j];
					// 初始字符与目标字符匹配，相等则标识+1
					if (ori == dest) {
						sign++;
					}
				}
			}

			if (sign <= 2) { // 如果字符出现次数小于3次，将此字符加入结果集
				result.add(ori);
			} else { // 否则加入到临时结果集
				tempBuffer.add(ori);
			}
		}
		return result;
	}
}
