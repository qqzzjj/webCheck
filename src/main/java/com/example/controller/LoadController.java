package com.example.controller;

import com.example.entity.U;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class LoadController {
    @Autowired
    UserService userService;
    @RequestMapping("/loginCheck")
    public String checkLoad(@Valid @RequestParam(value = "username")String username,
                            @Valid @RequestParam(value = "password")String password,
                            HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        U u = new U();
        u.setUsername(username);
        u.setPassword(password);
        if(userService.loadCheck(u) != null){
            return "success.html";
        }else{
            response.getWriter().print("<script>alert('用户名密码错误');window.location='login.html'</script>");
            return null;
        }
    }



}
