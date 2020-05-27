package com.lpc.learn.dubbo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
        while (true) {
            try {
                Thread.currentThread().wait();
            } catch (InterruptedException e) {
                log.error("阻塞被打断,",e);
            }
        }
    }
}