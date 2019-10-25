package org.wmx.jwy.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wmx.jwy.commons.service.HelloService;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class sayHelloController {
    @Reference
    HelloService helloService;

    @RequestMapping("/hello")
    public ResponseEntity<String> hello(){
    	System.out.println("wwwwwwwwwwww");
        String a = helloService.sayHello("jason");
        return ResponseEntity.ok(a);
    }
}