package com.zhangwei.springboot.mapper;

import com.zhangwei.springboot.entities.Bill;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/3 15:07
 * @Description:
 */

public interface BillMapper {
    Bill getBillById(Integer bid);

    int addBill(Bill bill);
}
