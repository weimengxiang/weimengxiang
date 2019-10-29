package org.tj.jwy.dtl.service.imp;

import org.tj.jwy.dtl.service.DtlTestService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class DtlTestServiceImp implements DtlTestService {

	@Override
	public int dtlTest(int paran) {
		// TODO Auto-generated method stub
		return paran;
	}

}
