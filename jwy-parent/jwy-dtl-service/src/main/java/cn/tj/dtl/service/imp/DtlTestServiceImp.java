package cn.tj.dtl.service.imp;

import com.alibaba.dubbo.config.annotation.Service;

import cn.tj.dtl.service.DtlTestService;

@Service
public class DtlTestServiceImp implements DtlTestService {

	@Override
	public int dtlTest(int paran) {
		// TODO Auto-generated method stub
		return paran;
	}

}
