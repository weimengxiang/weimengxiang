package org.wmx.jwy.commons.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.wmx.jwy.commons.bean.UserBean;
import org.wmx.jwy.commons.mapper.UserMapper;
import org.wmx.jwy.commons.service.UserServiceI;

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
    
    

}