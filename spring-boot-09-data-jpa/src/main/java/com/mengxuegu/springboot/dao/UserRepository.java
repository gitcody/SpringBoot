package com.mengxuegu.springboot.dao;

import com.mengxuegu.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/4 11:44
 * @Description:
 */

public interface UserRepository extends JpaRepository<User, Integer> {
}
