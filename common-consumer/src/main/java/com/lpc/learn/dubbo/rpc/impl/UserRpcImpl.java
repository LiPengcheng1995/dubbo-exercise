package com.lpc.learn.dubbo.rpc.impl;

import com.alibaba.fastjson.JSON;
import com.lpc.learn.dubbo.domain.Request;
import com.lpc.learn.dubbo.domain.Response;
import com.lpc.learn.dubbo.rpc.UserRpc;
import com.lpc.learn.dubbo.soa.UserSoa;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

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
    private UserSoa singleUserSoa;

    private UserSoa batchUserSoa;

    @Override
    public String deal(String input) {
        return singleUserSoa.deal(Request.build(input)).getData();
    }

    @Override
    public String dealBatch(String input) {
        Response<String> response = batchUserSoa.deal(Request.build(input));
        return JSON.toJSONString(response.getMergedResponseList().stream()
                .map(res->res.getData())
                .collect(Collectors.toList()));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("common-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");



        ReferenceConfig<UserSoa> single = new ReferenceConfig<>();
        single.setApplication(applicationConfig);
        single.setRegistry(registryConfig);
        single.setInterface(UserSoa.class);
        single.setGroup("*");
        single.setTimeout(10000);
        singleUserSoa = single.get();


        ReferenceConfig<UserSoa> batch = new ReferenceConfig<>();
        batch.setApplication(applicationConfig);
        batch.setRegistry(registryConfig);
        batch.setInterface(UserSoa.class);
        batch.setGroup("*");
        batch.setMerger("lpcMerger");
        batchUserSoa = batch.get();
    }
}
