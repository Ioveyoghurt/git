package com.atguigu.controller;

import com.atguigu.bean.ClassInfo;
import com.atguigu.bean.PaperInfo;
import com.atguigu.bean.StudentScore;
import com.atguigu.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private StudentDao studentDao;


    @RequestMapping("/studentsScore")
    public String studentsScore(Model model){

        List<StudentScore> scores = studentDao.getStudentsScore();
        model.addAttribute("scores",scores);
        return "teacher/listStudentsScore";
    }

    @RequestMapping("/showClassInfo")
    public String showClassInfo(Model model){
        List<ClassInfo> infos = studentDao.showClassInfo();
        model.addAttribute("infos",infos);
        return "teacher/showClassInfo";
    }

    @RequestMapping("/showPaperInfo")
    public String showPaperInfo(Model model){
        List<PaperInfo> paperInfos = studentDao.showPaperInfo();
        model.addAttribute("paperInfos",paperInfos);
        return "teacher/showPaperInfo";
    }
}
