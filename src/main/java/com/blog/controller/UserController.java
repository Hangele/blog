package com.blog.controller;

import com.blog.mapper.user.User;
import com.blog.service.user.IUserService;
import com.blog.utils.ServerResponse;
import com.blog.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @package: com.blog.controller
 * @Date: 2019/2/25 21:47
 * @Author: Hangele
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping("/login")
    public ServerResponse<User> login(UserVO request){
        return userService.login(request);
    }

}
