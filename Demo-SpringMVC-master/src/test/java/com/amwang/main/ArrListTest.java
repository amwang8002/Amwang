/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年5月14日  
* @version 1.0  
*/ 
package com.amwang.main;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amwang.biz.AbstractSpringContextTestSupport;
import com.amwang.utils.ChartUtils;
import com.amwang.utils.JsonUtils;

/**  
* <p>Title: ArrListTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年5月14日  
*/
public class ArrListTest extends AbstractSpringContextTestSupport {

	@Test
	public void arrlistTest() {
		List<ModelPoJo> modelPoJos = buildModel();
		System.out.println(JsonUtils.list2JsonString(modelPoJos));
		for (ModelPoJo modelPoJo : modelPoJos) {
			String name = modelPoJo.getName();
			String [] names = name.split("-");
			modelPoJo.setName(names[0]);
		}
		System.out.println(JsonUtils.list2JsonString(modelPoJos));
	}
	
	public List<ModelPoJo> buildModel(){
		List<ModelPoJo> result = new ArrayList<ModelPoJo>();
		ModelPoJo model1 = new ModelPoJo();
		model1.setName("aaa-111");
		model1.setCode("code1");
		result.add(model1);
		
		ModelPoJo model2 = new ModelPoJo();
		model2.setName("bbb-222");
		model2.setCode("code2");
		result.add(model2);
		return result;
	}
	
	@Autowired
	public void ChartTest() {
		
		String randomCharts = ChartUtils.getRandomStr(8);
		System.out.println(randomCharts);
	}
}
