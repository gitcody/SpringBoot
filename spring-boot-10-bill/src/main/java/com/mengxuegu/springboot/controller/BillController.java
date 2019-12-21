package com.mengxuegu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/26 0026 下午 23:14
 * @Description:
 */

@Controller
public class BillController {
    @GetMapping("/bills")
    public String list() {
        int i = 1 / 0;
        return "bill/list";
    }
}
