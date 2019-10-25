package cn.tj.test.kk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.tj.serviceapi.TestServiceApi;

@RestController
public class TestController {
	@Autowired
	TestServiceApi testserviceapi;
	
	@RequestMapping(value="/hello")
	public int get(){		
		return testserviceapi.test(2222);
	}
	
	

}
