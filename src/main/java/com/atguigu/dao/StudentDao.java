package com.atguigu.dao;


import com.atguigu.bean.ClassInfo;
import com.atguigu.bean.PaperInfo;
import com.atguigu.bean.StudentScore;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StudentDao {

    @Select("SELECT sid,sname,cname,scscore \n" +
            "\t\tFROM student \n" +
            "\t\tINNER JOIN stu_course \n" +
            "\t\t\tON student.`sid`=stu_course.`scsid` \n" +
            "\t\tINNER JOIN course \n" +
            "\t\t\tON course.`cid`=stu_course.`sccid` \n" +
            "\t\tWHERE sid=#{sid}")
    List<StudentScore> getStudentScore(Integer sid);


    @Select("SELECT sid,sname,cname,scscore \n" +
            "\t\tFROM student \n" +
            "\t\tINNER JOIN stu_course \n" +
            "\t\t\tON student.`sid`=stu_course.`scsid` \n" +
            "\t\tINNER JOIN course \n" +
            "\t\t\tON course.`cid`=stu_course.`sccid` ")
    List<StudentScore> getStudentsScore();


    @Select("select * from class")
    List<ClassInfo> showClassInfo();

    @Select("SELECT psid,sname,STATUS \n" +
            "\t\tFROM paper \n" +
            "\t\tINNER JOIN student \n" +
            "\t\t\tON student.`sid`=paper.`psid`\n")
    List<PaperInfo> showPaperInfo();

    @Select("SELECT psid,sname,STATUS \n" +
            "\t\tFROM paper \n" +
            "\t\tINNER JOIN student \n" +
            "\t\t\tON student.`sid`=paper.`psid` where sid=#{sid}\n")
    PaperInfo showStudentPaperInfo(String sid);

    @Update("UPDATE paper SET STATUS = '已提交' WHERE psid = #{psid} ")
    void changePaperStatus(Integer psid);

    @Select("select sid from student where sid=#{sid}")
    Integer selectId (Integer sid);
}
