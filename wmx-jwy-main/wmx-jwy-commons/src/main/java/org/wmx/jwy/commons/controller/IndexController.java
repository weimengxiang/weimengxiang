package org.wmx.jwy.commons.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.wmx.jwy.commons.bean.UserBean;
import org.wmx.jwy.commons.service.UserServiceI;

@RestController
public class IndexController {

    @Autowired
    private UserServiceI userService;
    @RequestMapping(value = "/get")
    public UserBean get() {
    	UserBean user = userService.getUserById(1);
        return user;

    }
    @RequestMapping(value="/update")
    public UserBean update() {
        UserBean user=userService.getUserById(1);
        user.getUsername("test");
        return userService.update(user);
    }
    
    @RequestMapping(value="/del")
    public String del() {
        return userService.del(1);
    }

}