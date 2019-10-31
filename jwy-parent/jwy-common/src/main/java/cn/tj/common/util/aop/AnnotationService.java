package cn.tj.common.util.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/*
 * @weimengxiang
 * 
 * 自定义注解， 作用于service层，对对外暴露的接口进行调用管控
 * 
 * 依赖spring的加载该注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) 
@Component
public @interface AnnotationService {
	    //操作
		//String operate();
		
		//是否拦截
		//boolean ispublic() default true;
		String  description() default "";
}
