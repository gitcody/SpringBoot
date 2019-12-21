package com.zhangwei.springboot.controller;

import com.zhangwei.springboot.entities.Bill;
import com.zhangwei.springboot.mapper.BillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/3 16:01
 * @Description:
 */

@RestController
public class BillController {
    @Autowired
    BillMapper billMapper;

    @GetMapping("/bill/{bid}")
    public Bill getBill(@PathVariable("bid") Integer bid) {
        Bill bill = billMapper.getBillById(bid);
        return bill;
    }

    @GetMapping("/bill")
    public Bill addBill(Bill bill) {
        int i = billMapper.addBill(bill);
        return bill;
    }
}
