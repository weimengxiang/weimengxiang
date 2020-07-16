package cn.tj;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

import cn.tj.conf.BaseIntercaptConf;
import cn.tj.conf.SwaggerConfig;

@SpringBootApplication
//@Import({BaseIntercaptConf.class,SwaggerConfig.class})
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
