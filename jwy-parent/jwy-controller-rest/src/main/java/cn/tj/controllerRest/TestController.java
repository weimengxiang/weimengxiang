package cn.tj.controllerRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import cn.tj.common.service.TestServiceApi;

@RestController
public class TestController {
	@Reference
	TestServiceApi testserviceapi;
	
	@RequestMapping(value="/hello")
	public int get(){		
		return testserviceapi.test(2222);
	}
	
	

}
