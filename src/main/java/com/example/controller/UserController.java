package com.example.controller;


import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author nostalgia
 * @since 2019-04-17
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @Autowired
    UserService userService;

    @GetMapping("/getById")
    public Object getUserById(String id){
        return userService.getById(id);
    }

    /*@GetMapping("/saveUser")
    public String addUser(String name,String sex){
        User user = new User();
        user.setCreated(new Date());
        user.setName(name);
        user.setSex(sex);
        String id = UUID.randomUUID().toString().replace("-", "");
        user.setId(id);
        String s = saveUser(user);
        if("ok".equals(s)){
            return "新增成功";
        }else{
            return s;
        }
    }*/

    @GetMapping("/saveUser")
    public String saveUser(@Valid User user, BindingResult result){
        if(result.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for(FieldError error : result.getFieldErrors()){
                String message = error.getDefaultMessage();
                sb.append(message).append(";");
            }
            return sb.toString().substring(0,sb.length()-1);
        }else{
            userService.save(user);
            return "新增成功!";
        }
    }

    @GetMapping("/getAll")
    public Object getUserById(){

        throw new NullPointerException("测试空指针异常...");
    }


}
