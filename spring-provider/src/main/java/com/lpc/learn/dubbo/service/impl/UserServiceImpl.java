package com.lpc.learn.dubbo.service.impl;

import com.lpc.learn.dubbo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/27
 * @Time: 20:27
 * @Description:
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public String deal(String input) {
        return "收到入参:"+input;
    }
}
