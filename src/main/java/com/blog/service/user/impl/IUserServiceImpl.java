package com.blog.service.user.impl;

import com.blog.mapper.user.User;
import com.blog.mapper.user.UserMapper;
import com.blog.service.user.IUserService;
import com.blog.utils.ServerResponse;
import com.blog.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @package: com.blog.service.user
 * @Date: 2019/2/25 21:51
 * @Author: Hangele
 * @Description:
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public ServerResponse<User> login(UserVO request) {
        User user = userMapper.selectByUsernameAndPassword(request);
        return ServerResponse.createBySuccess(user);
    }
}
