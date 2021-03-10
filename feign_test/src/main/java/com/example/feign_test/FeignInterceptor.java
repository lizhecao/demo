package com.example.feign_test;

import com.alibaba.fastjson.JSON;
import feign.RequestInterceptor;
import feign.RequestTemplate;

/**
 * @author lizhecao 2020/12/26
 * @version 1.0
 */
public class FeignInterceptor implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate template) {
    // 通过template获取到请求体（已经被转成json）
    String jsonBody = template.requestBody().asString();
    // 构造通用的请求体
    BaseReq baseReq = translateToBaseReq(jsonBody);
    // 替换请求体
    String baseReqStr = JSON.toJSONString(baseReq);
    template.body(baseReqStr);
  }

  private BaseReq translateToBaseReq(String jsonBody) {
    return null;
  }
}
