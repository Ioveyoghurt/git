package com.atguigu.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentScore {

    private Integer sid;
    private String sname;
    private String cname;
    private Double scscore;


}
