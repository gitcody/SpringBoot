package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * @Auther: RyanChang
 * @Date: 2019/11/24 0024 下午 20:04
 * @Description:
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    ProviderDao providerDao;

    @GetMapping("/providers")
    public String list(Map<String, Object> map, @RequestParam(value = "providerName", required = false) String providerName) {
        logger.info("供应商列表查询......" + providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers", providers);
        map.put("providerName", providerName);
        return "provider/list";
    }


    /**
     * type=null,查看view.html,type=update,查看update.html
     *
     * @param pid
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable("pid") Integer pid,
                       @RequestParam(value = "type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + pid + "的供应商详细信息");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider", provider);
        //type=null,则进入view.html,type=update则是进入update.html
        //return "provider/view";
        return "provider/" + type;
    }

    @PutMapping("/provider")
    public String update(Provider provider) {
        logger.info("更改供应商信息......");
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //前往添加页面
    @GetMapping("/provider")
    public String toAddPage() {
        return "provider/add";
    }

    //添加数据
    @PostMapping("/provider")
    public String add(Provider provider) {
        logger.info("添加供应商数据" + provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    //删除供应商
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable("pid") Integer pid) {
        logger.info("删除操作,pid" + pid);
        providerDao.delete(pid);
        return "redirect:/providers";
    }
}
