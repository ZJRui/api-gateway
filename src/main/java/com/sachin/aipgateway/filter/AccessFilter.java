package com.sachin.aipgateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    @Override
    public String filterType() {
        return "pre";//过滤器类型，代表在请求被路由之前执行
    }

    @Override
    public int filterOrder() {
        return 0;//过滤器的顺序
    }

    @Override
    public boolean shouldFilter() {
        return true;//直接返回true表示过滤器对所有请求都有效
    }

    @Override
    public Object run() throws ZuulException {

        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        logger.info("Send {} request to {}", request.getMethod(), request.getRequestURL().toString());
        String accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            logger.warn("access token is empty");
            currentContext.setSendZuulResponse(false);//设置过滤请求，不对该请求进行路由
            currentContext.setResponseStatusCode(401);
            return null;
        }

        logger.info("access token ok");

        return null;

    }
}
