package cn.tj.common.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import cn.tj.common.bean.UserBean;

@Mapper
public interface UserMapper {
	
	UserBean findOne(@Param("uuid")int uuid);
	
	UserBean save(@Param("userbean")UserBean userbean);
	
	UserBean delete(@Param("uuid")int uuid);
	
	List<UserBean> getTestpage();
	
}
