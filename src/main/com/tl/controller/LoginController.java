package com.tl.controller;

import com.tl.mapper.TUserMapper;
import com.tl.pojo.QueryVo;
import com.tl.pojo.TUser;
import com.tl.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private TUserService userService;
    @Autowired
    private TUserMapper userMapper;

    @RequestMapping(value = "/login.action",method = RequestMethod.GET)
    //@ModelAttribute(value = "name") String name 接收重定向传来的参数
    public String login(@ModelAttribute(value = "name") String name,Model model){
        System.out.println(name+" get");

        model.addAttribute("tip",name);
        return "login";
    }

    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String userCode, String userPwd, HttpSession httpSession, Model model) {

        System.out.println("post");
        TUser user = userService.selectByNameAndPass(userCode,userPwd);
        System.out.println(userCode);
        System.out.println(user);
        if (user==null||"".equals(user))
        {
            System.out.println("tip");

        }
        httpSession.setAttribute("USERCODE_SESSION",userCode);
        httpSession.setAttribute("USERPWD_SESSION",userPwd);

        return "redirect:/customer/list";
    }


}
