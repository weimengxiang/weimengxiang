package cn.tj.common;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import cn.tj.common.conf.RedisConfig;

@SpringBootApplication
@MapperScan("cn.tj.common.mapper")
@EnableCaching  //开启缓存
@EnableDubbo
@Import({RedisConfig.class})
@EnableScheduling  
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
