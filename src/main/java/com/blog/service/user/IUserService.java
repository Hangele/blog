package com.blog.service.user;

import com.blog.mapper.user.User;
import com.blog.utils.ServerResponse;
import com.blog.vo.UserVO;

/**
 * @package: com.blog.service.user.impl
 * @Date: 2019/2/25 21:52
 * @Author: Hangele
 * @Description:
 */
public interface IUserService {

    ServerResponse<User> login(UserVO request);

}
