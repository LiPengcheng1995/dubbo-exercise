package com.lpc.learn.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * Package: com.lpc.learn.dubbo
 * User: 李鹏程
 * Email: lipengcheng3@jd.com
 * Date: 2020/5/27
 * Time: 18:30
 * Description:
 * @date 2020-05-27 19:47
 * @author lipengcheng3
 */
@Slf4j
@SpringBootApplication
@ImportResource(locations = {"classpath:dubbo/dubbo.xml"})
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        while (true) {
            try {
                Thread.currentThread().wait();
            } catch (Throwable e) {
                log.error("阻塞被打断,",e);
            }
        }
    }
}