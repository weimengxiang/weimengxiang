package org.wmx.jwy.commons;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.wmx.jwy.commons.conf.BaseIntercaptConf;
import org.wmx.jwy.commons.conf.RedisConfig;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

@SpringBootApplication
@EnableDubbo
@MapperScan("org.wmx.jwy.commons.mapper")
@EnableScheduling  //定时任务
@EnableCaching  //开启缓存
@Import({RedisConfig.class,BaseIntercaptConf.class})
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
