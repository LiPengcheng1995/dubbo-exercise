package com.lpc.learn.dubbo.rpc;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 10:31
 * @Description:
 */
public interface UserRpc {
    String deal(String input);
    String dealBatch(String input);
}
