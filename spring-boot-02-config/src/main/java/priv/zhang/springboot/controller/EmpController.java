package priv.zhang.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/14 0014 下午 12:32
 * @Description:
 */
@Controller
public class EmpController {
    @Value("${emp.last-name}")
    private String name;

    @ResponseBody
    @RequestMapping("/hello")
    public String sayHello() {
        return "hello" + name;
    }
}
