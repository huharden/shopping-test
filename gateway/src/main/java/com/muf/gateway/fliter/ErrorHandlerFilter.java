package com.muf.gateway.fliter;

import com.muf.common.utils.JsonUtil;
import com.muf.common.utils.R;
import com.muf.common.utils.Tools;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

/**
 * description:
 * @author: hutao
 * @date 2019/4/2 15:59
 */
@Slf4j
@Component
public class ErrorHandlerFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        try {
            RequestContext ctx = RequestContext.getCurrentContext();
            Object e = ctx.get("throwable");

            if (e instanceof ZuulException) {
                ZuulException zuulException = (ZuulException) e;
                // 删除该异常信息,不然在下一个过滤器中还会被执行处理
                ctx.remove("throwable");
                // 根据具体的业务逻辑来处理
                log.error("网关异常，请检查微服务状态：", zuulException);
                ctx.setResponseStatusCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                ctx.setResponseBody(JsonUtil.toJson(R.error("网关异常，请检查微服务状态", Tools.exceptionInfo(zuulException))));
                ctx.getResponse().setContentType("application/json;charset=UTF-8");
            }
        } catch (Exception ex) {
            log.error("网关自定义错误过滤器异常:", ex);
        }
        return null;
    }
}
