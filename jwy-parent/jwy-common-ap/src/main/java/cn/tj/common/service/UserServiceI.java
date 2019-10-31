package cn.tj.common.service;

import com.github.pagehelper.PageInfo;

import cn.tj.common.bean.UserBean;

public interface UserServiceI {

    UserBean getUserById(int i);

    UserBean update(UserBean user);

    String del(int id);

	PageInfo<UserBean> getTestpage(int pageNum, int pageSize);

}