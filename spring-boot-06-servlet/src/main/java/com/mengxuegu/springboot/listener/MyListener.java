package com.mengxuegu.springboot.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/27 0027 下午 21:27
 * @Description:
 */

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("springboot servlet应用启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("springboot servlet应用销毁");
    }
}
