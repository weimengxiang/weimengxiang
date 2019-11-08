package cn.tj.informationmanage.service.imp;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.informationmanage.mapper.TestMapper;
import cn.tj.informationmanage.service.TestService;

@Service
public class TestServiceImp implements TestService {

	@Autowired
	TestMapper testMapper;
	@Override
	public String getUser() {
		return testMapper.getUser();
	}

}
