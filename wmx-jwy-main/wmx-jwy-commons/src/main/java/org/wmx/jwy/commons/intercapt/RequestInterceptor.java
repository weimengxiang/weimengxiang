package org.wmx.jwy.commons.intercapt;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
/*
 * @auto WMX
 * 对登录请求拦截，拒绝无用户登录访问
 * 
 */
import org.springframework.web.servlet.ModelAndView;


public class RequestInterceptor implements HandlerInterceptor {
	
	private static final Logger LOG = LogManager.getLogger(RequestInterceptor.class);
/*
 * (non-Javadoc)
 * @see org.springframework.web.servlet.HandlerInterceptor#afterCompletion(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)
 * 请求处理结束之后调用
 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}
/*
 * (non-Javadoc)
 * @see org.springframework.web.servlet.HandlerInterceptor#postHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, org.springframework.web.servlet.ModelAndView)
 * 请求处理之后调用，但在视图没有渲染之前（controller之后）
 * 
 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
/*
 * (non-Javadoc)
 * @see org.springframework.web.servlet.HandlerInterceptor#preHandle(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object)
 * 请求处理之前调用（controller调用之前）
 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		boolean bool = true;
		LOG.info("请求方法安全认证拦截...............");
	
		
		bool = true;
		return bool;
	}

}
