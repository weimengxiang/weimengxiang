package cn.tj.controllerRest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.tj.jwy.dtl.service.DtlTestService;

import com.alibaba.dubbo.config.annotation.Reference;
import cn.tj.common.service.TestServiceApi;

@RestController
public class TestController {
	@Reference
	TestServiceApi testserviceapi;
	@Reference
	DtlTestService dtltestservice;
	
	@RequestMapping(value="/common/hello")
	public int getCommon(){		
		return testserviceapi.test(2222);
	}
	@RequestMapping(value="/Dtl/hello")
	public int getDtl(){		
		return testserviceapi.test(3333);
	}
	
	
	

}
