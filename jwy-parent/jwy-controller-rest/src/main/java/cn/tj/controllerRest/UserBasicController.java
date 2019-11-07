package cn.tj.controllerRest;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.service.UserBasicService;

@RestController
@RequestMapping(value="/UserBasic")
public class UserBasicController {
	@Reference
	UserBasicService userbasicservice;
	
	@RequestMapping(value="/userlogin")
	public JSONObject userlogin(String username,String password,HttpServletRequest httpservletrequest){
		
	    //返回登陆标志
		Map status = userbasicservice.userlogin(username,password);
		httpservletrequest.getSession().setAttribute("token", status.get("token"));
		JSONObject jsb = new JSONObject();
		jsb.put("token", status.get("token"));
		jsb.put("retmsg", status.get("retmsg"));
		jsb.put("retcode", status.get("retcode"));
		return jsb;
	}
	@RequestMapping(value="/userregister")
	public String register(UserLoginBean userbean){
		  //返回登陆标志
		String status = userbasicservice.register(userbean);
		
		return status;
	}

}
