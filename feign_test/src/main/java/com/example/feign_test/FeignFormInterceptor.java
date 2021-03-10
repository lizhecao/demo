package com.example.feign_test;

import com.alibaba.fastjson.JSON;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collections;

import static feign.form.ContentProcessor.CONTENT_TYPE_HEADER;
import static feign.form.ContentType.URLENCODED;

/**
 * @author lizhecao 2020/12/26
 * @version 1.0
 */
public class FeignFormInterceptor implements RequestInterceptor {
  @Autowired
  SpringFormEncoder encoder;

  @Override
  public void apply(RequestTemplate template) {
    // 通过template获取到请求体（已经被转成json）
    String jsonBody = template.requestBody().asString();
    // 构造通用的请求体
    BaseReq baseReq = translateToBaseReq(jsonBody);
    // 先改造下header成表单头
    template.header(CONTENT_TYPE_HEADER, Collections.<String>emptyList()); // reset header
    template.header(CONTENT_TYPE_HEADER, URLENCODED.getHeader());
    // 通过encoder的encode方法，将我们的数据 改成表单数据，并替换掉原来的template中的body
    encoder.encode(baseReq, Encoder.MAP_STRING_WILDCARD, template);
  }

  private BaseReq translateToBaseReq(String jsonBody) {
    return null;
  }
}
