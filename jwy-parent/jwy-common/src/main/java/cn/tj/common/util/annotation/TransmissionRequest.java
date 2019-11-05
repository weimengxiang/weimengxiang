package cn.tj.common.util.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.stereotype.Component;

/*
 * @weimengxiang
 * 
 * 自定义注解，作用在类上和方法上，用于请求url拦截
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface TransmissionRequest {
	 //检验是否登录
    boolean required() default true;
}
