package cn.tj.common.service.imp;
import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.common.service.TokenService;
import cn.tj.common.util.UUIDGenerator;

@Service
public class TokenServiceImp implements TokenService  {

	@Override
	public String createToken() {
		//简单创建
		String  str = UUIDGenerator.getUUID();
		StringBuffer sb = new StringBuffer(str);
		return sb.toString();
	}

	@Override
	public void checkToken() {
		// TODO Auto-generated method stub
		
	}

}
