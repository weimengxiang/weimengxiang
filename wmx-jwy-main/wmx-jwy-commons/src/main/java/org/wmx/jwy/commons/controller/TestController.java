package org.wmx.jwy.commons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wmx.jwy.commons.service.TestService;

@RestController

public class TestController {
  @Autowired
  TestService testService;
  @Autowired
  private StringRedisTemplate redisTemplate;
  @RequestMapping(value="/gettest")
  public String gettest(){
	  System.out.println("2111111111212121212");
	  System.out.println(redisTemplate);
	  redisTemplate.opsForValue().set("mane", "nihao");
	  return testService.getTest();
  }
  
}
