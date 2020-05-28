package com.lpc.learn.dubbo.config;

import com.lpc.learn.dubbo.service.UserService;
import com.lpc.learn.dubbo.service.impl.UserServiceImpl;
import com.lpc.learn.dubbo.soa.UserSoa;
import com.lpc.learn.dubbo.soa.UserSoaImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 15:54
 * @Description:
 */
@Slf4j
@Configuration
public class CommonConfig {

    @Bean
    public UserService userService(){
        return new UserServiceImpl();
    }

    @Bean
    public UserSoa userSoa(UserService userService){
        return new UserSoaImpl(userService);
    }
}
