package com.lpc.learn.dubbo.rpc.impl;

import com.lpc.learn.dubbo.domain.Request;
import com.lpc.learn.dubbo.rpc.UserRpc;
import com.lpc.learn.dubbo.soa.UserSoa;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 10:32
 * @Description:
 */
@Slf4j
@Service
public class UserRpcImpl implements UserRpc, InitializingBean {
    private UserSoa userSoa;

    @Override
    public String deal(String input) {
        return userSoa.deal(Request.build(input)).getData();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("common-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");

        ReferenceConfig<UserSoa> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface(UserSoa.class);

        userSoa = referenceConfig.get();
    }
}
