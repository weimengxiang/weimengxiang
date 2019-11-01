package cn.tj.common.service;

import cn.tj.common.bean.UserLoginBean;

public interface UserBasicService {
    //登录
	public String userlogin(String username,String password);
    //注册
	public String register(UserLoginBean userbean);

}
