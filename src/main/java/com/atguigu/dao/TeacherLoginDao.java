package com.atguigu.dao;

import com.atguigu.bean.StuLogin;
import com.atguigu.bean.TeacherLogin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TeacherLoginDao {

    @Select("select * from teacher_login where login_num = #{loginNum}")
    TeacherLogin selectByNum(String loginNum);

    @Results({
            @Result(id = true, column = "login_num", property = "loginNum"),
            @Result(column = "password", property = "password")
    })
    @Insert("insert into teacher_login values(#{loginNum},#{password})")
    void insert(TeacherLogin teacherLogin);

}
