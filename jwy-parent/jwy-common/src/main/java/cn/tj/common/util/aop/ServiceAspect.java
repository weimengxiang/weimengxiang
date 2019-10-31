package cn.tj.common.util.aop;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

/*
 * @weimengxiang 
 * 
 * 切面，完成注解对service层的调用拦截，已经访问人数统计
 * 
 */
@Component
@Aspect
public class ServiceAspect {
	
	private static final Logger Log = LogManager.getLogger(ServiceAspect.class);
	
	
	//切点位置
	@Pointcut("@annotation(cn.tj.common.util.aop.AnnotationService)")
//	@Around("@annotation(org.wmx.jwy.commons.utilauto.AnnotationService)")
	public void ServiceAspectinit(){
      Log.info("切面执行");
	}
	
	@Before("ServiceAspectinit()")
	public void doBeforeAnnotationService(JoinPoint joinpoint){
		
	try {
	    	
		    ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();  
			if(null != attributes){
				HttpServletRequest request = attributes.getRequest(); 
				Map<String, String[]> map = request.getParameterMap();
				Log.info("URL : " + request.getRequestURL().toString());  
				Log.info("HTTP_METHOD : " + request.getMethod());  
				Log.info("IP : " + request.getRemoteAddr());  
				Log.info("CLASS_METHOD : " + joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());  
				Log.info("ARGS : " + Arrays.toString(joinpoint.getArgs()));  
			}else{
				MethodSignature methodSignature = (MethodSignature) joinpoint.getSignature();
				Method method =  methodSignature.getMethod();
		        Log.info("CLASS_METHOD : " + joinpoint.getSignature().getDeclaringTypeName() + "." + joinpoint.getSignature().getName());
		        Log.info("ARGS : " + Arrays.toString(joinpoint.getArgs()));
				Log.info(method.getName());
				Log.info(joinpoint.getSignature().getDeclaringTypeName());
				Log.info(joinpoint.getTarget());
			}
	} catch (Exception e) {
		e.printStackTrace();
	}catch (Throwable e) {
		Log.info("aaaa");
		e.printStackTrace();
	}
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
 
 
    @Around("ServiceAspectinit()")
    public Object aroundMethod(ProceedingJoinPoint pjp)throws Throwable{
        System.out.println(pjp.proceed());
        return  pjp.proceed();
    }


	
    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
     /*public  static String getServiceMthodDescription(JoinPoint joinPoint)
             throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
         for (Method method : methods) {
             if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                 if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(AnnotationService. class).description();
                    LOG.info("======"+description+"======");
                    break;
                }
            }
        }
         return description;
    }*/

}	