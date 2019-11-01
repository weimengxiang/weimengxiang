package cn.tj.sysnotice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*@MapperScan("cn.tj.common.mapper")
@EnableCaching  //开启缓存
@EnableDubbo
@EnableScheduling  */
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
