package cn.tj.common.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.tj.common.bean.UserLoginBean;
import cn.tj.common.mapper.UserMapper;
import cn.tj.common.util.HandleResult;
import cn.tj.common.util.annotation.AnnotationService;
import cn.tj.service.api.UserServiceI;

@Service
@CacheConfig(cacheNames="users")
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;
    
  //@Cacheable(key="'userCache'")
    @Cacheable
    @Override
    public UserLoginBean getUserById(int i) {
        System.out.println("执行这里，说明缓存中读取不到数据，直接读取数据库....");
        return userMapper.findOne(i);
    }

    @CachePut(key="'userCache'")
    @Override
    public UserLoginBean update(UserLoginBean user) {
        System.out.println("执行这里，更新数据库，更新缓存....");
        return userMapper.save(user);
    }
 
    @CacheEvict(key="'userCache'")
    @Override
    public String del(int id) {
        userMapper.delete(id);
        return "删除成功！！！！";
    }
    
    @AnnotationService
	@Override
	public String getTestpage(int pageNum,int pageSize) {
		// TODO Auto-generated method stub
		 PageHelper.startPage(pageNum, pageSize);
		 List<UserLoginBean> list = userMapper.getTestpage();
		 PageInfo<UserLoginBean> pageinfo = new PageInfo<>(list);
		 
		return HandleResult.ResultData("100", "请求成功",pageinfo);
	}
    
    

}