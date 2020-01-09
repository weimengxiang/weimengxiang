package cn.tj.informationmanage.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/**
 * 
 * @author weimenhxaing
 * 
 * 接口的监控服务，性能监控，调用次数统计等
 * 
 * 作用在，类和方法上 依赖spring的加载该注解
 * 
 *  @Target({ElementType.TYPE,ElementType.METHOD})
	@Retention(RetentionPolicy.RUNTIME) 
	@Component
 *
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) 
@Component
public @interface InterfaceMonitor {
	
	boolean description() default true;

}
