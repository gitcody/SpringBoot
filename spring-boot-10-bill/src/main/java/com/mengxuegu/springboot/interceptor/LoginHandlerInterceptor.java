package com.mengxuegu.springboot.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/25 0025 下午 19:50
 * @Description:
 */

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object loginUser = request.getSession().getAttribute("loginUser");
        if (loginUser != null) {
            return true;
        }
        request.setAttribute("msg", "没有权限,请先登录");
        request.getRequestDispatcher("/index.html").forward(request, response);
        return false;
    }
}
