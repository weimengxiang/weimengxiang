package cn.tj.conf;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import cn.tj.intercapt.RequestInterceptor;

/*
 *  定义一个全局拦截配置
 */
@Configuration
@Component
public class BaseIntercaptConf extends WebMvcConfigurationSupport {
	
	private static final Logger LOG = LogManager.getLogger(BaseIntercaptConf.class);

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		//拦截下所有的方法
		LOG.info("自定义拦截器拦截...........");
		registry.addInterceptor(new RequestInterceptor()).addPathPatterns("/*/**"); 
		LOG.info("自定义拦截器拦截结束...........");
		super.addInterceptors(registry);
	}

	
}
