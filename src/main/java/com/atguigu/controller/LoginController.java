package com.atguigu.controller;

import com.atguigu.bean.StuLogin;
import com.atguigu.bean.TeacherLogin;
import com.atguigu.dao.StuLoginDao;
import com.atguigu.dao.TeacherLoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private StuLoginDao stuLoginDao;

    @Autowired
    private TeacherLoginDao teacherLoginDao;

    @RequestMapping("/login")
    public String login(String loginNum, String password, String identity, HttpSession session){

        if(identity == null)
            return "redirect:/indexBoth.jsp";

        if(identity.equals("学生")) {
            StuLogin stuLogin = stuLoginDao.selectByNum(loginNum);
            if (stuLogin == null) {
                System.out.println("该用户不存在,请先注册");
                return "redirect:/indexBoth.jsp";
            }
            if (!stuLogin.getPassword().equals(password)) {
                System.out.println("用户名或密码不正确请重新输入");
                return "redirect:/indexBoth.jsp";
            }
            session.setAttribute("student",stuLogin);
          return "student/studentIndex";
        }
        else {
            TeacherLogin teacherLogin = teacherLoginDao.selectByNum(loginNum);
            if (teacherLogin == null) {
                System.out.println("该用户不存在,请先注册");
                return "redirect:/indexBoth.jsp";
            }
            if (!teacherLogin.getPassword().equals(password)) {
                System.out.println("用户名或密码不正确请重新输入");
                return "redirect:/indexBoth.jsp";
            }
            session.setAttribute("teacher",teacherLogin);
            return "/teacher/teacherIndex";
        }
    }

}
