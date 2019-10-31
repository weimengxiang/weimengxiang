package cn.tj.common.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import com.alibaba.dubbo.config.annotation.Service;
import cn.tj.common.bean.UserBean;
import cn.tj.common.mapper.UserMapper;
import cn.tj.common.service.UserServiceI;

@Service
@CacheConfig(cacheNames="users")
public class UserServiceImpl implements UserServiceI {

    @Autowired
    private UserMapper userMapper;
    
  //  @Cacheable(key="'userCache'")
    @Cacheable
    @Override
    public UserBean getUserById(int i) {
        System.out.println("执行这里，说明缓存中读取不到数据，直接读取数据库....");
        return userMapper.findOne(i);
    }

    @CachePut(key="'userCache'")
    @Override
    public UserBean update(UserBean user) {
        System.out.println("执行这里，更新数据库，更新缓存....");
        return userMapper.save(user);
    }
 
    @CacheEvict(key="'userCache'")
    @Override
    public String del(int id) {
        userMapper.delete(id);
        return "删除成功！！！！";
    }

	@Override
	public List<UserBean> getTestpage() {
		// TODO Auto-generated method stub
		return userMapper.getTestpage();
	}
    
    

}