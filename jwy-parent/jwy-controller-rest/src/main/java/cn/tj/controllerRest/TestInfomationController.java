package cn.tj.controllerRest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.informationmanage.service.TestService;

@RestController
@RequestMapping("/informationmanage")
public class TestInfomationController {
	
	@Reference
	TestService testService;
	
	@RequestMapping(value="/testInfomatio")
	public String testInfomatio(){
		
		return testService.getUser();
		
	}

}
