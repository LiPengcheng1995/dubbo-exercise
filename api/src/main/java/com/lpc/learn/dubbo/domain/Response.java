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
public class Response<T> {
    private T data;
    private Integer code;

    public static <T> Response<T> buildSuccess(T data){
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setData(data);
        return response;
    }
}
