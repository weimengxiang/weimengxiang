package cn.tj.common.service;
import cn.tj.common.bean.UserLoginBean;

public interface UserServiceI {

    UserLoginBean getUserById(int i);

    UserLoginBean update(UserLoginBean user);

    String del(int id);

	String getTestpage(int pageNum, int pageSize);

}