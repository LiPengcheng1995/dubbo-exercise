package com.lpc.learn.dubbo.soa;

import com.lpc.learn.dubbo.domain.Request;
import com.lpc.learn.dubbo.domain.Response;
import com.lpc.learn.dubbo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/27
 * @Time: 21:58
 * @Description:
 */
public class UserSoaImpl implements UserSoa {

    private UserService userService;

    public UserSoaImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public Response<String> deal(Request<String> request) {
        return Response.buildSuccess(userService.deal(request.getData()));
    }
}
