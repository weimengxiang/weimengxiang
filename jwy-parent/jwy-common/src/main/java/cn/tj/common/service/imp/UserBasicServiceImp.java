package cn.tj.common.service.imp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.mapper.UserBasicServiceMapper;
import cn.tj.common.service.TokenService;
import cn.tj.common.service.UserBasicService;
import cn.tj.common.util.annotation.AnnotationService;
import cn.tj.common.util.annotation.ApiIdempotent;


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
	
	@Override
	@AnnotationService  
	public String userlogin(String username,String password) {
		UserLoginBean user = userbasicservicemapper.userlogin(username,password);
		String token = tokenservice.createToken();
		redistemplate.opsForValue().set(token, token);
		if(user != null){
			return LOGIN_SUCCESS;	
		}
		return LOGIN_FAIL;
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
