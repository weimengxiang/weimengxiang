package org.wmx.jwy.commons.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.wmx.jwy.commons.mapper.TestMapper;
import org.wmx.jwy.commons.service.TestService;

@Service
public class TestServiceImp implements TestService {
  @Autowired
  TestMapper testMapper;

@Override	
public String getTest() {
	return testMapper.getUser();
}
}
