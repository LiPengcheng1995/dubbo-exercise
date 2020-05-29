package com.lpc.learn.dubbo.rpc.impl;

import com.alibaba.fastjson.JSON;
import com.lpc.learn.dubbo.rpc.UserRpc;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.rpc.service.GenericService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
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
    public static final String[] DEAL_INPUT_TYPE = new String[]{"com.lpc.learn.dubbo.domain.Request"};
    @Resource
    private GenericService userSoa;

    @Resource
    private GenericService userSoaBatch;


    @Override
    public String deal(String input) {
        Map<String, Object> req = new HashMap<>();
        req.put("data", input);
        req.put("class", "com.lpc.learn.dubbo.domain.Request");
        return JSON.toJSONString(userSoa.$invoke("deal", DEAL_INPUT_TYPE, new Object[]{req}));
    }

    @Override
    public String dealBatch(String input) {
        Map<String, Object> req = new HashMap<>();
        req.put("data", input);
        req.put("class", "com.lpc.learn.dubbo.domain.Request");
        return JSON.toJSONString(userSoaBatch.$invoke("deal", DEAL_INPUT_TYPE, new Object[]{req}));
    }
}
