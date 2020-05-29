package com.lpc.learn.dubbo.rpc.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lpc.learn.dubbo.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

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

    private GenericService genericService;

    public static final String[] DEAL_INPUT_TYPE = new String[]{"com.lpc.learn.dubbo.domain.Request"};
    @Override
    public String deal(String input) {
        Map<String,Object> req = new HashMap<>();
        req.put("data",input);
        req.put("class","com.lpc.learn.dubbo.domain.Request");
        return JSON.toJSONString(genericService.$invoke("deal", DEAL_INPUT_TYPE, new Object[]{req}));
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("common-generic-consumer");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");


        ReferenceConfig<GenericService> referenceConfig = new ReferenceConfig<>();
        referenceConfig.setApplication(applicationConfig);
        referenceConfig.setRegistry(registryConfig);
        referenceConfig.setInterface("com.lpc.learn.dubbo.soa.UserSoa");
        referenceConfig.setGeneric("true");
        referenceConfig.setGroup("*");

        genericService = referenceConfig.get();
    }
}
