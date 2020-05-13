package cn.tj.controllerRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.service.api.DtlTestService;

@RestController
public class TestDtlController {
	private static final Logger LOG = LogManager.getLogger(TestDtlController.class);
	@Reference
	DtlTestService dtltestservice;
	@RequestMapping(value="/dtl/hello")
	public int getDtl(){
		return dtltestservice.dtlTest(3333);
	}
	
}
