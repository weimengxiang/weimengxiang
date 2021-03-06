package cn.tj.controllerRest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.annocation.ApiIdempotent;
import cn.tj.common.bean.UserLoginBean;
import cn.tj.service.api.TestServiceApi;
import cn.tj.service.api.UserServiceI;

@RestController
@RequestMapping(value = "Common")
public class TestCommonController {
	private static final Logger LOG = LogManager.getLogger(TestCommonController.class);
	@Reference
	TestServiceApi testserviceapi;
	@Reference
	UserServiceI userservicei;
	@Autowired
	StringRedisTemplate redistemplate;
	
	@RequestMapping(value="/common/hello")
	public String getCommon(){	
		
		return testserviceapi.test(2222);
	}
	
	//测试redis注解缓存
	@RequestMapping(value="/common/getRedis")
	public UserLoginBean getRedis(){
		//return redistemplate.opsForValue().get("cfa9948a6cd44dc9be77e66ee43a29b7");
		return userservicei.getUserById(25);
	}
	

	@RequestMapping(value="/common/pagehalder",produces = "application/json;charset=UTF-8",method=RequestMethod.GET)
	public String gettest1(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="15")int pageSize){
		String res_list = userservicei.getTestpage(pageNum, pageSize);
		return res_list;
	  }
	

}
