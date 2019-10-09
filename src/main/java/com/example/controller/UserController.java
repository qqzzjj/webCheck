package com.example.controller;

import com.example.entity.U;
import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/getUser/{id}")
    public User getUser(@PathVariable(value = "id") int id){
        return userService.Sel(id);
    }

    @RequestMapping("/getAll")
    public List<User> getAllUser(){
        return userService.SelAll();
    }

    @RequestMapping("/insUser/{id}/{userName}/{passWord}/{realName}")
    public String insUser(@PathVariable(value = "id") int id,
                        @PathVariable(value = "userName") String username,
                        @PathVariable(value = "passWord") String password,
                        @PathVariable(value = "realName") String realName){
            User user = new User();
            user.setId(id);
            user.setUserName(username);
            user.setPassWord(password);
            user.setRealName(realName);

        if (userService.Ins(user)==1){
            return user.toString();
        }else {
            return "insert fail";
        }
    }

    @RequestMapping("/del/{id}")
    public String delUser(@PathVariable(value = "id")int id){
        if(userService.Del(id)==1){
            return "del success";
        }else {
            return "del fail";
        }
    }

    @RequestMapping("upd/{id}/{userName}/{passWord}/{realName}")
    public String updUser(@PathVariable(value = "id")int id,
                          @PathVariable(value = "userName") String username,
                          @PathVariable(value = "passWord") String password,
                          @PathVariable(value = "realName") String realName){
        User user = new User();
        user.setId(id);
        user.setUserName(username);
        user.setPassWord(password);
        user.setRealName(realName);
        if(userService.Upd(user)==1){
            return "update success";
        }else {
            return "update fail";
        }
    }

}
