package cn.tj.common.service.imp;
import cn.tj.common.service.TestServiceApi;
import com.alibaba.dubbo.config.annotation.Service;

@Service
public class TestServiceImp implements TestServiceApi {

	public int test(int paran) {
		// TODO Auto-generated method stub
		return paran;
	}

}
