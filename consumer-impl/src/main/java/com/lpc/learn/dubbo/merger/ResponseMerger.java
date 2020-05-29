package com.lpc.learn.dubbo.merger;

import com.lpc.learn.dubbo.domain.Response;
import org.apache.dubbo.rpc.cluster.Merger;

import java.util.Arrays;

/**
 * @author: 李鹏程
 * @email: lipengcheng3@jd.com
 * @date: 2020/5/28
 * @Time: 18:18
 * @Description:
 */
public class ResponseMerger<T extends Response> implements Merger<Response> {
    @Override
    public Response merge(Response... items) {
        Response response = new Response();
        response.setData(200);
        response.setMergedResponseList(Arrays.asList(items));
        return response;
    }
}
