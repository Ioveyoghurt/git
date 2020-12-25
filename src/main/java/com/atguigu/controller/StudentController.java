package com.atguigu.controller;

import com.atguigu.bean.PaperInfo;
import com.atguigu.bean.StuLogin;
import com.atguigu.bean.StudentScore;
import com.atguigu.dao.StudentDao;
import com.atguigu.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentDao studentDao;
    @Autowired
    private StudentService studentService;

//    @RequestMapping("/findRepeat")
//    public String findRepeat(Model model)throws FileNotFoundException {
//        String pathname1="C:\\Users\\80969\\Desktop\\double_check\\src\\main\\webapp\\file\\1111.txt";
//        String pathname2="C:\\Users\\80969\\Desktop\\double_check\\src\\main\\webapp\\file\\2222.txt";
//       double result = studentService.caculate(pathname1, pathname2);
//       //将double类型数据转换为百分数
//        DecimalFormat df = new DecimalFormat("0.00%");
//        String rates = df.format(result);
//        System.out.println(rates);
//       model.addAttribute("rates",rates);
//        return "student/findRepeat";
//
//    }

    @RequestMapping("/findRepeat")
    public String findRepeat(@RequestParam("file") MultipartFile[] file,Model model)throws FileNotFoundException {

        String[] str = new String[2];
        int i = 0;

        for (MultipartFile multipartFile : file) {
            if(!multipartFile.isEmpty()){
                try {
                    String path = "C:\\Users\\80969\\Desktop\\double_check\\src\\main\\webapp\\file";
                    String fileName = multipartFile.getOriginalFilename();
                    str[i++] = path+"\\"+fileName;
                    multipartFile.transferTo(new File(path,fileName));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
//                如果没上传或者少上传了文件就还跳转到上传文件的页面
                return "student/uploadAndFindRepeat";
            }
        }

        double result = studentService.caculate(str[0], str[1]);
        //将double类型数据转换为百分数
        DecimalFormat df = new DecimalFormat("0.00%");
        String rates = df.format(result);
        System.out.println(rates);
        model.addAttribute("rates",rates);
        return "student/findRepeat";

    }
    @RequestMapping("/getStudentScore")
    public String getStudentScore(HttpSession session,Model model){

        StuLogin stuLogin = (StuLogin) session.getAttribute("student");
        String loginNum = stuLogin.getLoginNum();
        List<StudentScore> studentScore = studentDao.getStudentScore(Integer.parseInt(loginNum));
        model.addAttribute("studentScore",studentScore);
        return "student/listStudentScore";
    }

    @RequestMapping("/fileUpload")
    public String fileUpload(@RequestParam("file") MultipartFile file,HttpSession session){

        String path = "C:\\Users\\80969\\Desktop\\double_check\\src\\main\\webapp\\file";
        String fileName = file.getOriginalFilename();
        File dir = new File(path,fileName);
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            file.transferTo(dir);
            StuLogin student = (StuLogin)session.getAttribute("student");
            Integer selectId = studentDao.selectId(Integer.parseInt(student.getLoginNum()));
            studentDao.changePaperStatus(selectId);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "student/studentIndex";
    }

    @RequestMapping("/paperStatus")
    public String paperStatus(Model model){
        List<PaperInfo> infos = studentDao.showPaperInfo();
        model.addAttribute("paperInfos",infos);

        return "teacher/showPaperInfo";
    }

    @RequestMapping("/paperStatusById")
    public String paperSatusById(Model model, HttpSession session){
        StuLogin student = (StuLogin) session.getAttribute("student");
        PaperInfo studentPaperInfo = studentDao.showStudentPaperInfo(student.getLoginNum());
        model.addAttribute("info",studentPaperInfo);

        return "student/paperStatus";
    }
}
