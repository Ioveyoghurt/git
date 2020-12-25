package com.atguigu.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherLogin {
    private String LoginNum;
    private String password;

    @Override
    public String toString() {
        return "TeacherLogin{" +
                "LoginNum='" + LoginNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
