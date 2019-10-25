package org.wmx.jwy.commons.serviceImp;

import org.wmx.jwy.commons.service.HelloService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class HelloServiceImp implements HelloService {

	@Override
	public String sayHello(String name) {
		 
		return "Hello "+name;
	}

}
