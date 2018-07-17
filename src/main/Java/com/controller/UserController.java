package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pojo.User;

@Controller
public class UserController {
    @Resource
   private UserService userService;

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("toIndex")
    public String toIndex(){ return "index"; }

    @RequestMapping("login")
    public void Login(HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.findUserByName(username);
        if(user!=null){
            if(user.getPassword().equals(password)){
                out.println(1);//登录成功
                Cookie cookie = new Cookie("username", username);
                response.addCookie(cookie);
            }else{
                out.print(2);//用户或密码不正确
            }
        }else{
            out.println(2);//用户或密码不正确
        }
    }

    @RequestMapping(value = "/register" )
    public void register(HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        userService.addUser(username, password);
        out.println(1);
    }

    @RequestMapping("checkUsername")
    public void checkUsername(HttpServletRequest request,HttpServletResponse response) throws IOException{
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        User user = userService.findUserByName(username);
        if(user!=null){
            out.println(1);
        }
    }}
