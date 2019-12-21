package priv.zhang.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.zhang.springboot.service.EmpService;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/14 0014 下午 14:56
 * @Description:
 */
@Configuration
public class EmpConfig {
    @Bean
    public EmpService empService2() {
        System.out.println(" @Bean注解已经将 EmpService 组件注入");
        return new EmpService();
    }
}
