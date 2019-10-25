package org.wmx.jwy.commons.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.wmx.jwy.commons.bean.UserBean;

@Mapper
public interface UserMapper {
	
	UserBean findOne(@Param("uuid")int uuid);
	UserBean save(@Param("userbean")UserBean userbean);
	UserBean delete(@Param("uuid")int uuid);
	
}
