package cn.tj.common.service.imp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSONObject;

import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.mapper.UserBasicServiceMapper;
import cn.tj.common.service.TokenService;
import cn.tj.common.service.UserBasicService;
import cn.tj.common.util.annotation.AnnotationService;



@Service
public class UserBasicServiceImp implements UserBasicService {
	
	private static final String LOGIN_SUCCESS = "1";  //登陆成功
	private static final String LOGIN_FAIL = "0";   //登录失败
	private static final String REGISTER_SUCCESS = "1"; //注册成功
	private static final String REGISTER_FAIL = "0";  //注册失败
	private static final String REGISTER_UNSER = "2"; //账户名存在

	@Autowired
	UserBasicServiceMapper userbasicservicemapper;
	@Autowired
	private StringRedisTemplate redistemplate;
	@Autowired
	TokenService  tokenservice;
	@SuppressWarnings("unchecked")
	@Override
	//@AnnotationService  
	public Map userlogin(String username,String password) {
		Map map = new HashMap();
		String token = tokenservice.createToken();
		UserLoginBean user = userbasicservicemapper.userlogin(username,password);
		redistemplate.opsForValue().set(token, token);
		if(user != null){
			map.put("retcode", "成功");
			map.put("token", token);
			map.put("retmsg",LOGIN_SUCCESS);
			return map;	
		}
		map.put("retcode", "失败");
		map.put("token", token);
		map.put("retmsg",LOGIN_FAIL);
		return map;
	}
	@Override
	@AnnotationService
	public String register(UserLoginBean userbean) {
	
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SDF.format(new Date());
		userbean.setPassword("123456");
		userbean.setUsername("wmx");
		
        int ishave = userbasicservicemapper.nspectUserName(userbean.getUsername());
		if(ishave == 0){
			//插入并返回 userid 主键
			int userloginbean = userbasicservicemapper.register(userbean);
			
			if(userloginbean != 0){
				return REGISTER_SUCCESS;
			}else{
				return REGISTER_FAIL;
			}
		}else{
			return REGISTER_UNSER;
		}	

	}

}
