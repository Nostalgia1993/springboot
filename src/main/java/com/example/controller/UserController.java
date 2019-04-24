package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author notalgia
 * @since 2019-04-23
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    public List<User> getUser(){
        return userService.list();
    }

    @RequestMapping("/testE")
    public List<User> testE(){
        User user = userService.getById("1");
        LocalDateTime birthday = user.getBirthday();
        return null;
    }



}
