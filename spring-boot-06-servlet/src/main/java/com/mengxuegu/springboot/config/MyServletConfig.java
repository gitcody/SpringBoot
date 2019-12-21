package com.mengxuegu.springboot.config;

import com.mengxuegu.springboot.filter.MyFilter;
import com.mengxuegu.springboot.listener.MyListener;
import com.mengxuegu.springboot.servlet.HelloServlet;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletContextListener;
import java.util.Arrays;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/27 0027 下午 21:11
 * @Description:
 */

@Configuration
public class MyServletConfig {

    /**
     * 注册Servlet组件
     */
    @Bean
    public ServletRegistrationBean hello() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new HelloServlet(), "/hello");
        bean.setLoadOnStartup(1);
        return bean;
    }

    /**
     * 注册Filter组件
     */
    @Bean
    public FilterRegistrationBean myFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //设置自定义Filter
        bean.setFilter(new MyFilter());
        //过滤哪一些请求
        bean.setUrlPatterns(Arrays.asList("/hello"));
        return bean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener() {
        ServletListenerRegistrationBean bean = new ServletListenerRegistrationBean(new MyListener());
        return bean;
    }

    @Bean
    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
        return new WebServerFactoryCustomizer() {
            @Override
            public void customize(WebServerFactory factory) {
                ConfigurableServletWebServerFactory castFactory = (ConfigurableServletWebServerFactory) factory;
                castFactory.setPort(8082);
                castFactory.setContextPath("/servlet2");
            }
        };
    }
}
