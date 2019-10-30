package cn.tj.common.service;

import cn.tj.common.bean.UserBean;

public interface UserServiceI {

    UserBean getUserById(int i);

    UserBean update(UserBean user);

    String del(int id);

}