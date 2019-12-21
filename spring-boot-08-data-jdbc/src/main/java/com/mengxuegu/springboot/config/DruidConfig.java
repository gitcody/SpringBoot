package com.mengxuegu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/28 0028 下午 21:00
 * @Description:
 */

@Configuration
public class DruidConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid() {
        return new DruidDataSource();
    }

    //1.配置一个druid的后台管理servlet
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> bean =
                new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        Map<String, String> initParam = new HashMap<>();
        initParam.put(StatViewServlet.PARAM_NAME_USERNAME, "root");
        initParam.put(StatViewServlet.PARAM_NAME_PASSWORD, "123");
        initParam.put(StatViewServlet.PARAM_NAME_ALLOW, "");
        initParam.put(StatViewServlet.PARAM_NAME_DENY, "192.168.0.5");
        bean.setInitParameters(initParam);
        return bean;

    }

    //2.配置一个druid的filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        Map<String, String> initParam = new HashMap<>();
        initParam.put(WebStatFilter.PARAM_NAME_EXCLUSIONS, "*.js,*.css,/druid/*");
        bean.setInitParameters(initParam);
        bean.setFilter(new WebStatFilter());
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
