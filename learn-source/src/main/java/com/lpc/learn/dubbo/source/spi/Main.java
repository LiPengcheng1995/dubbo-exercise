package com.lpc.learn.dubbo.source.spi;

import lombok.extern.slf4j.Slf4j;

import java.util.ServiceLoader;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/6/11
 * @Time: 10:14
 * @Description:
 */
// TODO 注意，这里用的是 jdk 的 spi 加载器。这里不要引用 dubbo 的包，否则会被覆盖，
@Slf4j
public class Main {
    public static void main(String[] args) {
        ServiceLoader x = ServiceLoader.load(HeHeDa.class);
        for (Object temp : x) {
            if (temp instanceof HeHeDa) {
                log.info("className:{},message:{}", temp.getClass().getSimpleName(), ((HeHeDa) temp).getMessage());
            }else {
                log.error("拿到一个陌生的对象，{}",temp.getClass().getSimpleName());
            }
        }
    }
}
