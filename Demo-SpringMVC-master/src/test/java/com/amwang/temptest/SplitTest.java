/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年4月30日  
* @version 1.0  
*/
package com.amwang.temptest;

import org.springframework.util.StringUtils;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.utils.JsonUtils;

/**
 * <p>
 * Title: SplitTest
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author amwang
 * @date 2019年4月30日
 */
public class SplitTest extends AbstractSpringContextTestSupport {

	public static void main(String[] args) {

		String[] array = new String[] { "1", "3", "3", "3", "2", "2", "2", "3", "1", "8", "5", "9", "1", "5", "6", "2",
				"3", "8", "8", "5", "9" };
		String[] destarr = rmRepeatNum(array);

		System.out.println(JsonUtils.obj2JsonString(destarr));
	}

	/**
	 * 
	 * <p>
	 * Title: abd
	 * </p>
	 * <p>
	 * Description: Given a 1-d array candy crush, return the shortest array after
	 * removing all the continuous same numbers (the repeating number >= 3) input:
	 * 1-d array [1, 3, 3, 3, 2, 2, 2, 3, 1] return: [1, 1] Time complexity should
	 * be better than O(n^2)
	 * </p>
	 */
	public static String[] rmRepeatNum(String[] array) {

		// 结果字符串
		StringBuffer result = new StringBuffer();
		// 临时字符串，用来存放数组中超过三个的字符
		StringBuffer tempBuffer = new StringBuffer();

		for (int i = 0; i < array.length; i++) {
			// 原始数组中字符个数标识初始化，默认为1个
			int sign = 1;

			String ori = array[i];
			// 如果临时字符串不为空或者字符中包含当前要比较的字，跳过本次比较继续循环
			if (!StringUtils.isEmpty(tempBuffer.toString()) && tempBuffer.toString().contains(ori)) {
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
					String dest = array[j];
					// 初始字符与目标字符匹配，相等则标识+1
					if (ori.equals(dest)) {
						sign++;
					}
				}
			}

			if (sign <= 2) { // 如果字符出现次数小于3次，将此字符加入结果集
				result.append(ori).append(",");
			} else { // 否则加入到临时结果集
				tempBuffer.append(ori);
			}
		}
		return result.toString().split(",");
	}
}
