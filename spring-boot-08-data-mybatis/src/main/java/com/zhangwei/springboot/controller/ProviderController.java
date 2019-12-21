package com.zhangwei.springboot.controller;

import com.zhangwei.springboot.entities.Provider;
import com.zhangwei.springboot.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/2 21:55
 * @Description:
 */

@RestController
public class ProviderController {

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid") Integer pid) {
        Provider provider = providerMapper.getProviderById(pid);
        return provider;
    }

    @GetMapping("/provider")
    public Provider addProvider(Provider provider) {
        providerMapper.addProvider(provider);
        return provider;
    }
}
