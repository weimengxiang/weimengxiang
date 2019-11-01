package cn.tj.common.service.imp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.mapper.UserBasicServiceMapper;
import cn.tj.common.service.UserBasicService;
import cn.tj.common.util.aop.AnnotationService;


@Service
public class UserBasicServiceImp implements UserBasicService {
	
	private static final String LOGIN_SUCCESS = "1";
	private static final String LOGIN_FAIL = "0";
	private static final String REGISTER_SUCCESS = "1";
	private static final String REGISTER_FAIL = "0";

	@Autowired
	UserBasicServiceMapper userbasicservicemapper;
	@Override
	@AnnotationService  
	public String userlogin(String username,String password) {
		UserLoginBean user = userbasicservicemapper.userlogin(username,password);
		if(user != null){
			return LOGIN_SUCCESS;	
		}
		return LOGIN_FAIL;
	}
	@Override
	public String register(UserLoginBean userbean) {
	
		SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		SDF.format(new Date());
		userbean.setPassword("123456");
		userbean.setUsername("wmx");
		//插入并返回 userid 主键
		int userloginbean = userbasicservicemapper.register(userbean);
		System.out.println(userloginbean+"ssssssssssssssssssssss");
		if(userloginbean != 0){
			return REGISTER_SUCCESS;
		}
		return REGISTER_FAIL;
	}

}
