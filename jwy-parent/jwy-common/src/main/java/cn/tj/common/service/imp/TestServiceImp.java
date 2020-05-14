package cn.tj.common.service.imp;
import org.springframework.beans.factory.annotation.Autowired;
import com.alibaba.dubbo.config.annotation.Service;
import cn.tj.common.mapper.TestMapper;
import cn.tj.common.util.UUIDGenerator;
import cn.tj.service.api.TestServiceApi;
import sun.util.locale.provider.LocaleServiceProviderPool;

@Service
public class TestServiceImp implements TestServiceApi {
    @Autowired
    TestMapper testMapper;
	public String test(int paran) {
		
		//return testMapper.getUser();
	   System.out.println("调用到了哦");
		return UUIDGenerator.getUUID();
		
	}

}
