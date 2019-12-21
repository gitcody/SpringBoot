package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.UserRepository;
import com.mengxuegu.springboot.entity.User;
import com.mengxuegu.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @Auther: ZhangWei
 * @Date: 2019/12/4 12:30
 * @Description:
 */

@RestController
public class UserController {
    @Autowired
    UserRepository userRepository;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.get();
        return user;
    }

    @GetMapping("/user")
    public User addUser(User user) {
        User save = userRepository.save(user);
        return save;
    }


    @Autowired
    IUserService userService;

    @GetMapping("/user2")
    public User addUser2(User user) {
        userService.addUser(user);
        return user;
    }
}
