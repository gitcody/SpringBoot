package priv.zhang.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/7 0007 下午 20:27
 * @Description:
 */
@Controller
public class InitController {
    @ResponseBody
    @RequestMapping("/info")
    public String init() {
        return "hello init...";
    }
}
