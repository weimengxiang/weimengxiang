package cn.tj.controllerRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.jwy.dtl.service.DtlTestService;
import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.common.bean.UserBean;
import cn.tj.common.service.TestServiceApi;
import cn.tj.common.service.UserServiceI;

@RestController
public class TestController {
	@Reference
	TestServiceApi testserviceapi;
	@Reference
	DtlTestService dtltestservice;
	@Reference
	UserServiceI userservicei;
	
	@RequestMapping(value="/common/hello")
	public String getCommon(){	
		
		return testserviceapi.test(2222);
	}
	//测试redis注解缓存
	@RequestMapping(value="/common/getRedis")
	public UserBean getRedis(){
		return userservicei.getUserById(1);
	}
	
	@RequestMapping(value="/dtl/hello")
	public int getDtl(){
		return dtltestservice.dtlTest(3333);
	}
	
}
