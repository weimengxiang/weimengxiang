package cn.tj.common.service;

import com.github.pagehelper.PageInfo;

import cn.tj.common.bean.UserLoginBean;

public interface UserServiceI {

    UserLoginBean getUserById(int i);

    UserLoginBean update(UserLoginBean user);

    String del(int id);

	PageInfo<UserLoginBean> getTestpage(int pageNum, int pageSize);

}