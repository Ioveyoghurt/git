package com.atguigu.dao;

import com.atguigu.bean.StuLogin;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;


@Mapper
public interface StuLoginDao {

    @Select("select * from stu_login where login_num = #{loginNum}")
    StuLogin selectByNum(String loginNum);

    @Results({
            @Result(id = true,column = "login_num",property = "loginNum"),
            @Result(column = "password",property = "password")
    })
    @Insert("insert into stu_login values(#{loginNum},#{password})")
    void insert(StuLogin stuLogin);
}
