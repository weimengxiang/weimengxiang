package cn.tj.common.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.tj.common.bean.UserLoginBean;

@Mapper
public interface UserMapper {
	
	UserLoginBean findOne(@Param("uuid")int uuid);
	
	UserLoginBean save(@Param("userbean")UserLoginBean userbean);
	
	UserLoginBean delete(@Param("uuid")int uuid);
	
	List<UserLoginBean> getTestpage();
	
}
