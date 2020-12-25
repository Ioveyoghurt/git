package com.atguigu.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuLogin {
    private String loginNum;
    private String password;



    @Override
    public String toString() {
        return "StuLogin{" +
                "loginNum='" + loginNum + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
