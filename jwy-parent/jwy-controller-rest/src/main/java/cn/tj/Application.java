package cn.tj;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import cn.tj.conf.BaseIntercaptConf;

@SpringBootApplication
@Import({BaseIntercaptConf.class})
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
	
}
