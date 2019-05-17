/**  
* <p>Title: DBF-ROOT  </p>  
* <p>Description: The program was developed to practice new methods and techniques in the learning process.
Just for the sake of learning.</p>  
* <p>Copyright: Copyright amwang (c) 2018</p>  
* <p>Company: www.nourl.com</p>  
* @author amwang  
* @date 2019年5月15日  
* @version 1.0  
*/ 
package com.amwang.icbcOpenPay;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.icbc.api.DefaultIcbcClient;
import com.icbc.api.IcbcApiException;
import com.icbc.api.IcbcResponse;
import com.icbc.api.request.EnterpriseOpenpayDirectPayRequestV1;
import com.icbc.api.request.EnterpriseOpenpayDirectPayRequestV1.EnterpriseOpenpayDirectPayGoodInfo;
import com.icbc.api.request.EnterpriseOpenpayDirectPayRequestV1.EnterpriseOpenpayDirectPayV1Biz;

/**  
* <p>Title: OpenPayTest</p>  
* <p>Description: </p>  
* @author amwang  
* @date 2019年5月15日  
*/
public class OpenPayTest {


	/**
	 * @param args
	 */

	protected static final String MY_PRIVATE_KEY = "BKa0yNWUiVVX/fv9rqRAhiCRK4OjxG7rOBj4Kpp9R6jDiJtpFD2RxGxN6gDZ/ucbZJ/FOz0v1uzWw9coJBVCOhawBBMZvQ36ha45yFw28Vp8xm091vBB9e3MfsW3B94OaVrGFqpbzds0qvSzubB3c9UaFQomX2Jpzpk0Wgm+Wl4RhGxVfWdJNu3E1NQWA7DxVl8fhra2o72yGbP/izXfZn0jSJEWZ4Pr4aFKeMkuGBfEVav0zsTWwsxsR9RGKfTMLF6z6dbaCjkjWBVB1aJUwXDChuwr8fgdcQVnDBYcf4jeogwavZLBiyY+r0F9hWSgylefoddac66Asko1JhJOO6KU4WSx+WmczF3myZ069rfq4yMfGzhvTJZ5F6sEOjtlMrNo/FBSLnRARRzLt4s+1Ki/vqhyF/hZ3RD91N90s0a3v1YwQ8j2f0RhYBHW945FfTCADsmjC2VoRd41pz0AzWVEHotAxOUG/DstYzvS6IOXZwLI57IYf3ObKCGR6pc1lOSxDh89i40zgfkC2iYDXKmM16h9FfyNKiLnvZDYllBr45CQW1tQT8Fkmz2vb4dZyT0ck0rGdYdTwfc9BvniekQIqh7uprmTtCevASWlW24mMeyi4in7dBvkT5bfkfjCyIV6aWOBkNWEfdSaOEBTnZMQ7KI/aqUKS6Zvj2c6A73jVmPlgkjXmanSVPKQD6NlvWt+VeyOHNb3uAw5eRplo87vg2bUDPT18uQ5J1xwM6gq9oYE4CzmtztTP9SkEp7Lzp0Py7KrG+d+9qNaISdtWbkggvqbHQ58MluZkfYoRgGbwxOYtzDXofma0Fu76iE06FQZGINwp7tMODl1qxeu6oTlM9VnSGIobNLKR1orGZhxGd4wILBTFBeDUpsJnlG/WNociDa6A5gGLF+Un4cF8gmjhjhM4NFdblMlk4PZslG2lvkRo4Sn/BKq7DKc8P8fOHCPqXvKHKy0OaOtnQXsdvbZenutaUU1FJXq7j6T0TciajiIzNPd0Nh7NolmYVaRAqHd58ulX6d9ZA99RyD0h/vGLZKSmABlq6fJd2+vSIN1cewIaz3XJp/BiT0iRg1eniFV3MA6Tu5sLUDPy7VDjGGghVn9PPH91aROpRuNlwFKIp2aHkdx1jFlJqxRkgbqfNcSgkQOm/jnFfCkC6aEu0y3yNDRVsmFSAKpKQTnbialLJc4Mqrtw//uaRtDKoKHGO0BcfM1Iy66PKWz66Jek9vMRBEuTuNJzbVwNOuzLUNDiHmsUAi15nVn/1J1oSgtRYfsJ3WUWpSBDcSlAhkg8/h61I9fmu1kimfs+w3uDTKpJ2qDDVIQSknd+Amlt818rVergssFnvY9dxtY2LroXsDW1tlBFOgHNQQJTcSvDCGdA7IOUaOpVArGZZcnuo6SQzy3ZeQza8/LsmlcDrjJcOAwx7uutUkVyP8u20zey4pH1a3wle9yMscGVrtK0XR+3DZQj+hiZ9jJxyVP4SKb0PuuFfBcwoqYwFkT9ScvZk+4//qZBe9oEmGfUscTNWipGwDhMkXwYYYo8VT22/d7nFeLL8RS8NYQikfFHGjU6OvLCR4Yn9JY7g==";

	protected static final String APIGW_PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwFgHD4kzEVPdOj03ctKM7KV+16bWZ5BMNgvEeuEQwfQYkRVwI9HFOGkwNTMn5hiJXHnlXYCX+zp5r6R52MY0O7BsTCLT7aHaxsANsvI9ABGx3OaTVlPB59M6GPbJh0uXvio0m1r/lTW3Z60RU6Q3oid/rNhP3CiNgg0W6O3AGqwIDAQAB";

	protected static final String APP_ID = "0200EH0005040"; 

	protected static final String password = "12345678";

	protected static final String MY_PUB_KEY = "MIIDljCCAn6gAwIBAgIKbaHKEE0tAAI0PTANBgkqhkiG9w0BAQsFADA3MRkwFwYDVQQKExBjb3JiYW5rNDMuY29tLmNuMRowGAYDVQQDExFjb3JiYW5rMTI4IHNkYyBDTjAeFw0xNzA1MjMwODE3NDJaFw0zMjA1MjMwODE3NDJaMEkxHTAbBgNVBAMMFDAyMDBFSDAwMDUwNDAuZS4wMjAwMQ0wCwYDVQQLDAQwMjAwMRkwFwYDVQQKDBBjb3JiYW5rNDMuY29tLmNuMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAmZryMysnjnxTL7CDTQk88R5jrwvZxrxCr1VsfKa62kxXh2LeDqhVkaYC3ZjhZeJ+OpNdU2k8kZahx++L5ZtZeZ4loKOzTHQ8nlVPD8cvnprLsNQzVEhAzaOOq91a0jgFHMYdAP9InIWllHvAluJqQThlGKLrpWfIdm7aUIV1EgglclMlCpw97R2MZnL6GcitSsJiof6XamEi00MyJ04MgJjFZouhBZhGkeZlXGG5O/iUzEAa1Zdj/dYHY5LpfES7BycLjmhvAot8n0HernjMF3afaJRr0IbBj81A9Ck8MSpaVypSsM0eQg/RU/bmN80I4cmHf7Rlkx8NQKj5yvFYmwIDAQABo4GRMIGOMB8GA1UdIwQYMBaAFJ6AEaO7V853/fEnZ/7k4X8i8lHzMEwGA1UdHwRFMEMwQaA/oD2kOzA5MQ0wCwYDVQQDDARjcmwxMQ0wCwYDVQQLDARjY3JsMRkwFwYDVQQKDBBjb3JiYW5rNDMuY29tLmNuMB0GA1UdDgQWBBT8MO4OzlJWZjHPeyjDNbtfNLbe/zANBgkqhkiG9w0BAQsFAAOCAQEAPFc63X7Nf9FT04gFWHwv3Zw7jM0oTejlQjfc1y2dI2XhSAa9nYjRXsGLxwFGyudf5AyZopOaNvrhbZpjVbOMl9gSwT/sWGjixOZ392Au4AYK0CZI0XzwDg9QOKucorwxb8xRCmCfgB2KVj0+Gw3qaMm5O7gQrvIsWqQVjjtuzin9Kg8vG9J+MrWbJcfCPIayiuhTPuWb0Kexxv+jjTFqb5G37x81Lqfjy9hPQjHObhHOAIoGE3OI6ua4N84dISsLY6xyp9OZGAToV5N4YH1Goi47O1vSI++ubv8D+gqEJDQ3H8vivP34A7ajVwCYwF5rVY03TvLWxAU+/v9RjsL+0g==";

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

		DefaultIcbcClient client = new DefaultIcbcClient(APP_ID,
				MY_PRIVATE_KEY, APIGW_PUBLIC_KEY, MY_PUB_KEY, password);

		// 设置请求对象request
		EnterpriseOpenpayDirectPayRequestV1 request = new EnterpriseOpenpayDirectPayRequestV1();

		// 设置请求路径
		request.setServiceUrl("https://gw-sandbox.open.icbc.com.cn/api/enterprise/openpay/directpay/V1");

		EnterpriseOpenpayDirectPayV1Biz bizContent = new EnterpriseOpenpayDirectPayV1Biz();

		bizContent.setPay_name("李尧集团人民币户");
		bizContent.setPay_rem("payremark");
		bizContent.setGet_phone("13426351013");
		bizContent.setTrade_time("20211010162925");
		bizContent.setGet_address("get_address");
		bizContent.setFile_code("0200EH0011036");
		bizContent.setPay_acct_num("0200062009213084848");
		bizContent.setOrder_no("orderzydl0050");
		bizContent.setGet_county("Qianshan");
		bizContent.setPay_phoneno("010-82706722");
		bizContent.setLanguage("ZH_CN");
		bizContent.setFile_serialno("fsZHJlyd0049");
		bizContent.setTradeplat_code("2018070000000000035");
		bizContent.setRec_name("再鳙拂再子芒烤");
		bizContent.setOrderAmt("3000");
		bizContent.setPay_mode("0");
		bizContent.setRec_orgcode("asdfsa");
		bizContent.setAmout("250");
		bizContent.setAcct_orgcode("12345");
		bizContent.setRec_bnkclscode("");
		bizContent.setChannel_flag("0");
		bizContent.setRec_acct_num("3602009009000401956");
		bizContent.setGet_post("100101");
		bizContent.setOrder_rem("订单备注test");
		bizContent.setCurrtype("001");
		bizContent.setFile_name("蜇惕艘厦潭配状滥务蛭迪参扮戒芒台");
		bizContent.setSign_flag("1");
		bizContent.setTradeplat_rem("tradeplat_rem");
		bizContent.setGet_email("www@139.com");
		bizContent.setGet_city("Anhui");
		bizContent.setTrade_orgcode("91350922MA34A6CP84");
		bizContent.setTradeplat_name("李尧集团基本户");
		bizContent.setGet_province("Anhui");
		bizContent.setSystem_flag("1");
		bizContent.setFile_id("0200EH0011036.e.0200");
		List<EnterpriseOpenpayDirectPayGoodInfo> goodlist = new ArrayList<EnterpriseOpenpayDirectPayGoodInfo>();
		
		EnterpriseOpenpayDirectPayGoodInfo goodinfo1 = new EnterpriseOpenpayDirectPayGoodInfo();
		goodinfo1.setGoods_name("苹果");
		goodinfo1.setGoods_num("11");
		goodinfo1.setGoods_seqno("SP001");
		goodinfo1.setPrice("850");
		goodinfo1.setSeller_phoneno("13811111111");
		goodinfo1.setSeller_name("appler_seller");
		goodinfo1.setUnits("KG");
		goodinfo1.setWeight("3");
		EnterpriseOpenpayDirectPayGoodInfo goodinfo2 = new EnterpriseOpenpayDirectPayGoodInfo();
		goodinfo2.setGoods_name("香蕉");
		goodinfo2.setGoods_num("11");
		goodinfo2.setGoods_seqno("SP002");
		goodinfo2.setPrice("850");
		goodinfo2.setSeller_phoneno("13811111111");
		goodinfo2.setSeller_name("appler_seller");
		goodinfo2.setUnits("KG");
		goodinfo2.setWeight("3");
		
		goodlist.add(goodinfo1);
		goodlist.add(goodinfo2);
		bizContent.setGoodlist(goodlist);
		
		request.setBizContent(bizContent);
		IcbcResponse response;

		Random rand = new Random();
		String msgId = rand.nextInt(99999) + "msg";
		System.out.println(msgId);

		try {
			response = client.execute(request, msgId);
			if (response.getReturnCode() == 0) {
				// 业务成功处理
				System.out.println("success");//
			} else {
				// 失败
				System.out.println("error:"+response.getReturnMsg());
			}
		} catch (IcbcApiException e) {
			e.printStackTrace();
		}
	}
}
