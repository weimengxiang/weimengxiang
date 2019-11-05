package cn.tj.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import cn.tj.common.bean.UserLoginBean;

@Mapper
public interface UserBasicServiceMapper {
    //登陆
	public UserLoginBean userlogin(@Param("username")String username,@Param("password")String password);
    //注册
	public int register(@Param("userbean")UserLoginBean userbean);
	
	public int nspectUserName(@Param("username")String username); //校验


}
