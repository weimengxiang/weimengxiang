package cn.tj.controllerRest;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.tj.jwy.dtl.service.DtlTestService;

import com.alibaba.dubbo.config.annotation.Reference;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.tj.common.bean.UserBean;
import cn.tj.common.service.TestServiceApi;
import cn.tj.common.service.UserServiceI;
import cn.tj.intercapt.RequestInterceptor;

@RestController
public class TestController {
	private static final Logger LOG = LogManager.getLogger(TestController.class);
	@Reference
	TestServiceApi testserviceapi;
	@Reference
	DtlTestService dtltestservice;
	@Reference
	UserServiceI userservicei;
	
	@RequestMapping(value="/common/hello")
	public String getCommon(){	
		
		return testserviceapi.test(2222);
	}
	//测试redis注解缓存
	@RequestMapping(value="/common/getRedis")
	public UserBean getRedis(){
		return userservicei.getUserById(1);
	}
	 @RequestMapping(value="/common/pagehalder")
	  public PageInfo<UserBean> gettest1(@RequestParam(value="pageNum",defaultValue="1")int pageNum,@RequestParam(value="pageSize",defaultValue="15")int pageSize){
	  
		 PageInfo<UserBean> res_list = userservicei.getTestpage(pageNum, pageSize);
	   
	      /*LOG.info("当前页数："+pageinfo.getPageNum());
	      LOG.info("每页数量："+pageinfo.getPageSize());
	      LOG.info("当前页面数量："+pageinfo.getSize());
	      LOG.info("总记录数："+pageinfo.getTotal());
	      LOG.info("总页数："+pageinfo.getPages());*/
		//  redisTemplate.opsForValue().set("mane", "nihao");
		  return res_list;
	  }
	
	@RequestMapping(value="/dtl/hello")
	public int getDtl(){
		return dtltestservice.dtlTest(3333);
	}
	
}
