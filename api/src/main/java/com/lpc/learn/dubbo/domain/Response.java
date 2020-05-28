package com.lpc.learn.dubbo.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/27
 * @Time: 20:29
 * @Description:
 */
@Data
public class Response<T> implements Serializable {
    private T data;
    private Integer code;

    private List<Response<T>> mergedResponseList;

    public static <T> Response<T> buildSuccess(T data) {
        Response<T> response = new Response<>();
        response.setCode(200);
        response.setData(data);
        return response;
    }
}
