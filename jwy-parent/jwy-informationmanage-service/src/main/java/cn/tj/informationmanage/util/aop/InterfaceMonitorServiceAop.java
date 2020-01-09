package cn.tj.informationmanage.util.aop;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Lists;

/**
 * 
 * @author weimengxiang
 * 
 * 注解  InterfaceMonitor 标记的服务aop处理
 *
 */
@Component
@Aspect
public class InterfaceMonitorServiceAop {

	private static final Logger LOG = LogManager.getLogger(InterfaceMonitorServiceAop.class);
	
	/*InterfaceMonitor作用*/
	@Pointcut("@annotation(cn.tj.informationmanage.util.annotation.InterfaceMonitor)")
	public void ServiceAspectinit(){
		LOG.info("接口拦截监控");
	}
	
	@Around("ServiceAspectinit()")
    public Object aroundMethod(ProceedingJoinPoint joinPoint){
        Object result = null;
        Stopwatch stopwatch = Stopwatch.createStarted();
        try {
        	LOG.info("服务开始！："+joinPoint.getSignature());
        	result = joinPoint.getArgs();
        	LOG.info("调用参数："+ Lists.newArrayList(joinPoint.getArgs()));
        	LOG.info("服务结束！："+joinPoint.getSignature()+", 返回");
        	LOG.info("耗时间："+stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)+"毫秒");
        	HttpServletRequest httpservletrequest =   ((HttpServletRequest) ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()));
        	StringBuffer url = httpservletrequest.getRequestURL();
        	LOG.info("url ："+url);
		} catch (Exception e) {
			 throw(e);
		}
        return result;
    }
	
	@Before("ServiceAspectinit()")
	public void doBeforeAnnotationService(JoinPoint joinpoint){
		System.out.println("前置通知!");
	}
	@AfterReturning("ServiceAspectinit()")
    public void afterMethod(){
        System.out.println("后置通知!");
    }
 
    @AfterThrowing("ServiceAspectinit()")
    public void afterThrowing()throws Throwable{
        System.out.println("异常通知");
    }
 
    @After("ServiceAspectinit()")
    public void finalMethod(){
        System.out.println("最终通知");
    }
	
}
