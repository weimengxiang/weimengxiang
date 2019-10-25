package org.wmx.jwy.commons.service;

import org.wmx.jwy.commons.bean.UserBean;

public interface UserServiceI {

    UserBean getUserById(int i);

    UserBean update(UserBean user);

    String del(int id);

}