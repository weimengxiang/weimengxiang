package cn.tj.dtl.service.imp;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.service.api.DtlTestService;

@Service
public class DtlTestServiceImp implements DtlTestService {

	@Override
	public int dtlTest(int paran) {
		// TODO Auto-generated method stub
		return paran;
	}

}
