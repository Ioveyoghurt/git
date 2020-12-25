package com.atguigu.controller;

import com.atguigu.bean.StuLogin;
import com.atguigu.bean.TeacherLogin;
import com.atguigu.dao.StuLoginDao;
import com.atguigu.dao.TeacherLoginDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RegisterController {

    @Autowired
    private StuLoginDao stuLoginDao;

    @Autowired
    private TeacherLoginDao teacherLoginDao;

    @RequestMapping("/register")
    public String register(String num,String password, String identity){
        if(null == num || null == password) {
            System.out.println("用户名和密码均不能为空");
            return "/signup";
        }
        if(stuLoginDao.selectByNum(num) != null){
            System.out.println("该用户名已注册");
            return "/signup";
        }
        if(num.length() > 9 || password.length() > 6){
            System.out.println("用户名或密码过长");
            return "/signup";
        }

        if(identity.equals("老师"))
            teacherLoginDao.insert(new TeacherLogin(num,password));
        else
            stuLoginDao.insert(new StuLogin(num,password));
        return "redirect:/indexBoth.jsp";
    }
}
