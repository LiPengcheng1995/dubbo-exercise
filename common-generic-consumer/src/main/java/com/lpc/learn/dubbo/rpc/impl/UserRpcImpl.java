package com.lpc.learn.dubbo.rpc.impl;

import com.alibaba.fastjson.JSON;
import com.lpc.learn.dubbo.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
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

    private GenericService singleService;

    private GenericService batchService;

    public static final String[] DEAL_INPUT_TYPE = new String[]{"com.lpc.learn.dubbo.domain.Request"};
    @Override
    public String deal(String input) {
        Map<String,Object> req = new HashMap<>();
        req.put("data",input);
        req.put("class","com.lpc.learn.dubbo.domain.Request");
        return JSON.toJSONString(singleService.$invoke("deal", DEAL_INPUT_TYPE, new Object[]{req}));
    }

    @Override
    public String dealBatch(String input) {
        Map<String,Object> req = new HashMap<>();
        req.put("data",input);
        req.put("class","com.lpc.learn.dubbo.domain.Request");
        return JSON.toJSONString(batchService.$invoke("deal", DEAL_INPUT_TYPE, new Object[]{req}));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("common-generic-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");


        ReferenceConfig<GenericService> single = new ReferenceConfig<>();
        single.setApplication(applicationConfig);
        single.setRegistry(registryConfig);
        single.setInterface("com.lpc.learn.dubbo.soa.UserSoa");
        single.setGeneric("true");
        single.setGroup("*");
        singleService = single.get();

        ReferenceConfig<GenericService> batch = new ReferenceConfig<>();
        batch.setApplication(applicationConfig);
        batch.setRegistry(registryConfig);
        batch.setInterface("com.lpc.learn.dubbo.soa.UserSoa");
        batch.setGeneric("true");
        batch.setGroup("*");
        batch.setMerger("objectMerger");
        batchService = batch.get();
    }
}
