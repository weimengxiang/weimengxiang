package cn.tj.controllerRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.service.TokenService;
import cn.tj.common.service.UserBasicService;

@RestController
@RequestMapping(value="/UserBasic")
public class UserBasicController {
	@Reference
	UserBasicService userbasicservice;
	
	@RequestMapping(value="/userlogin")
	public String userlogin(String username,String password){
		
	    //返回登陆标志
		String status = userbasicservice.userlogin(username,password);
	
		return status;
	}
	@RequestMapping(value="/userregister")
	public String register(UserLoginBean userbean){
		  //返回登陆标志
		String status = userbasicservice.register(userbean);
		
		return status;
	}

}
