package com.lpc.learn.dubbo.domain;

import lombok.Data;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/27
 * @Time: 20:29
 * @Description:
 */
@Data
public class Request<T> {
    private T data;

}
