package cn.tj.intercapt;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.util.StringUtil;

public class ApiIdempotentInterceptor implements HandlerInterceptor{
	private static final Logger LOG = LogManager.getLogger(ApiIdempotentInterceptor.class);
	@Autowired
	private StringRedisTemplate redistemplate;
    private static final String Token_NAME  = "token";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String tokenstr = "";
		if(!(handler instanceof HandlerMethod)){
			return true;
		}
		HandlerMethod handlemethod = (HandlerMethod) handler;
		Method method = handlemethod.getMethod();
		ApiIdempotent apiidempotent = method.getAnnotations();
		tokenstr  =  request.getHeader(Token_NAME);
		if(StringUtil.isEmpty(tokenstr)){
			tokenstr =  request.getParameter(Token_NAME);
			if(checktoken(tokenstr)){
				LOG.info("幂等检验通过!");
				return true;
			}
		}	return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
	
	private boolean checktoken(String key){
		boolean ishave = true;
		String redisvalue = redistemplate.opsForValue().get(key);
		if(StringUtil.isEmpty(redisvalue)){
			ishave = false;
		}
		return ishave;
		
		
	}

}
