package com.amwang.common;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 通过该类即可在普通工具类里获取spring管理的bean
 * @author wolf
 *
 */
public final class SpringContextUtils extends LogBase implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;
 
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringContextUtils.applicationContext == null) {
			SpringContextUtils.applicationContext = applicationContext;
			getLogger().info(
					"========ApplicationContext配置成功,在普通类可以通过调用ToolSpring.getAppContext()获取applicationContext对象,applicationContext="
							+ applicationContext + "========");
		}
	}
 
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
 
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}