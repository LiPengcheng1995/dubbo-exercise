package com.lpc.learn.dubbo.merger;

import com.lpc.learn.dubbo.domain.Response;
import org.apache.dubbo.rpc.cluster.Merger;

import java.util.Arrays;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/29
 * @Time: 16:40
 * @Description:
 */
public class ObjectMerger<T extends Object> implements Merger<Object>{
    @Override
    public Object merge(Object... items) {
        return Arrays.asList(items);
    }
}
