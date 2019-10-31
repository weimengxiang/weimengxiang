package cn.tj.common.util;

import java.util.UUID;

/*
 * @weimengxiang
 * 生成唯一标识 UUID通用工具类
 */
public class UUIDGenerator {
	
	public static String getUUID(){
		UUID uuid = UUID.randomUUID();
		String uuidstr = uuid.toString().trim().replaceAll("-", "");		
		return uuidstr;
	}
  
}
