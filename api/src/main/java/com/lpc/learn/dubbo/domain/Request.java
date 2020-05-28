package com.lpc.learn.dubbo.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/27
 * @Time: 20:29
 * @Description:
 */
@Data
public class Request<T> implements Serializable {
    private T data;

    public static <T> Request<T> build(T data) {
        Request<T> request = new Request<>();
        request.setData(data);
        return request;
    }
}
