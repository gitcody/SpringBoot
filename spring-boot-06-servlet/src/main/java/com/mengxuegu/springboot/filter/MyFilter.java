package com.mengxuegu.springboot.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/27 0027 下午 21:16
 * @Description:
 */

public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter初始化操作");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter过滤完成");
        //放行请求
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("filter销毁");
    }
}
