package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.U;
import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User Sel(int id);
    List<User> SelAll();
    int Ins(User user);
    int Del(int id);
    int Upd(User user);
    U checkLoad(U u);
    U registerCheck(U u);
    void registerIns(U u);
}
