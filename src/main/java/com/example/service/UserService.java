package com.example.service;

import com.example.entity.U;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public List<User> SelAll(){
        return userMapper.SelAll();
    }

    public int Ins(User user){
        return userMapper.Ins(user);
    }

    public int Del(int id){
        return userMapper.Del(id);
    }

    public int Upd(User user){
        return userMapper.Upd(user);
    }

    public U loadCheck(U u){
        return userMapper.checkLoad(u);
    }

    public U registerCheck(U u){
        return userMapper.registerCheck(u);
    }

    public void registerIns(U u){
        userMapper.registerIns(u);
    }


}
