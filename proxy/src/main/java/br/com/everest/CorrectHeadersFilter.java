package br.com.everest;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;

@Order(2)
@Component
@SuppressWarnings("unchecked")
public class CorrectHeadersFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 10000;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext currentContext = RequestContext.getCurrentContext();

        currentContext.addZuulRequestHeader("host", currentContext.getRequest()
                .getHeader("host"));

        // XXX
        currentContext.getZuulRequestHeaders().remove("x-forwarded-prefix");

        ((Set<String>) currentContext.get("ignoredHeaders")).clear();// XXX
        return null;
    }

}
