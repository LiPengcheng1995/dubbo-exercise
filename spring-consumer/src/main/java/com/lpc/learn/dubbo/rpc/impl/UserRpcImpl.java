package com.lpc.learn.dubbo.rpc.impl;

import com.alibaba.fastjson.JSON;
import com.lpc.learn.dubbo.domain.Request;
import com.lpc.learn.dubbo.domain.Response;
import com.lpc.learn.dubbo.rpc.UserRpc;
import com.lpc.learn.dubbo.soa.UserSoa;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.stream.Collectors;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 10:32
 * @Description:
 */
@Slf4j
@Service
public class UserRpcImpl implements UserRpc {
    @Resource
    private UserSoa userSoa;

    @Resource
    private UserSoa userSoaBatch;

    @Override
    public String deal(String input) {
        return userSoa.deal(Request.build(input)).getData();
    }

    @Override
    public String dealBatch(String input) {
        Response<String> response = userSoaBatch.deal(Request.build(input));
        return JSON.toJSONString(response.getMergedResponseList().stream()
                .map(res->res.getData())
                .collect(Collectors.toList()));
    }
}
