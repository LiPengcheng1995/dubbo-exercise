package com.lpc.learn.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 16:21
 * @Description:
 */
@Slf4j
@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo/dubbo.xml"})
public class SpringGenericConsumerMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringGenericConsumerMain.class, args);
    }

}
