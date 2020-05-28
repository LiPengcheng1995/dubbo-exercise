package com.lpc.learn.dubbo;

import com.lpc.learn.dubbo.service.UserService;
import com.lpc.learn.dubbo.service.impl.UserServiceImpl;
import com.lpc.learn.dubbo.soa.UserSoa;
import com.lpc.learn.dubbo.soa.UserSoaImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 15:45
 * @Description:
 */
@Slf4j
public class CommonProviderMain {
    public static void main(String[] args) {
        ApplicationConfig applicationConfig = new ApplicationConfig();
        applicationConfig.setName("common-provider");

        RegistryConfig registryConfig = new RegistryConfig();
        registryConfig.setAddress("127.0.0.1:2181");
        registryConfig.setProtocol("zookeeper");

        ProtocolConfig protocolConfig = new ProtocolConfig();
        protocolConfig.setName("dubbo");
        protocolConfig.setPort(20882);

        ServiceConfig<UserSoa> serviceConfig = new ServiceConfig<>();
        serviceConfig.setApplication(applicationConfig);
        serviceConfig.setRegistry(registryConfig);
        serviceConfig.setProtocol(protocolConfig);
        serviceConfig.setInterface(UserSoa.class);
        serviceConfig.setRef(new UserSoaImpl(new UserServiceImpl()));
        serviceConfig.setGroup("common-group");

        serviceConfig.export();

        try {
            System.in.read();
        }catch (Throwable throwable){
            log.error("收到退出信息");
        }
    }
}
