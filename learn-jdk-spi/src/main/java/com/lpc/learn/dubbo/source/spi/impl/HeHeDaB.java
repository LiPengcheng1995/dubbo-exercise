package com.lpc.learn.dubbo.source.spi.impl;

import com.lpc.learn.dubbo.source.spi.HeHeDa;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/6/11
 * @Time: 10:13
 * @Description:
 */
public class HeHeDaB implements HeHeDa {
    @Override
    public String getMessage() {
        return "这里是B实现";
    }
}
