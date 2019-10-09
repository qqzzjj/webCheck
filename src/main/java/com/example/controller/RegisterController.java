package com.example.controller;

import com.example.eamil.IMailServiceImpl;
import com.example.entity.U;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RegisterController {
    @Autowired
    UserService userService;
    @RequestMapping("/registerCheck")
    public String registerCheck(@Valid  @RequestParam(value = "username")String username,
                                @Valid  @RequestParam(value = "password")String password,
                                @Valid  @RequestParam(value = "email")String email,
                                HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        U u = new U();
        u.setUsername(username);
        u.setPassword(password);
        u.setEmail(email);
        if(userService.registerCheck(u)==null){
            userService.registerIns(u);
            return "success.html";
        }else {
            response.getWriter().print("<script>alert('该用户已存在');window.location='register.html'</script>");
            return null;
        }
    }

    @Autowired
    IMailServiceImpl iMailService;

    @RequestMapping(value = "/getYZM",method = RequestMethod.GET)
    @ResponseBody
    public Object getYZM(@Valid  @RequestParam(value = "email") String email){
        System.out.println(email);
        String subject = "验证码";
        String Verificationcode = ((String.valueOf(((Math.random()*9+1)*1000)))).substring(0,4);
        iMailService.sendSimpleMail(email,subject,Verificationcode);
        return Verificationcode;
    }
}
