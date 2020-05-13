package cn.tj.service.api;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

import cn.tj.common.bean.UserLoginBean;

public interface UserBasicService {
    //登录
	public <T> Map<String, T> userlogin(String username,String password);
    //注册
	public String register(UserLoginBean userbean);

}
