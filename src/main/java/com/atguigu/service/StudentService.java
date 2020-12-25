package com.atguigu.service;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * @author hahahei
 * @creatTime 2020-12-23-8:24
 */
public interface StudentService {
    public double caculate(String pathname1,String pathname2) throws FileNotFoundException;
    public HashMap<String, Integer> hanlp(String pathname) throws FileNotFoundException;
    public void Hashadd(HashMap<String,Integer> counter, String word);
}
