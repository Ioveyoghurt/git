package com.atguigu.service.impl;

import com.atguigu.service.StudentService;
import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.stopword.CoreStopWordDictionary;
import com.hankcs.hanlp.seg.common.Term;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author hahahei
 * @creatTime 2020-12-23-8:33
 */
@Service
public class StudentServiceImpl implements StudentService {

    //余弦算法
    public double caculate(String pathname1,String pathname2) throws FileNotFoundException {
        HashMap<String, Integer> map1 = hanlp(pathname1);
        HashMap<String, Integer> map2 = hanlp(pathname2);
        double sum1=0;
        double sum2=0;
        double sumTop=0;
        double result;
        //通过使用余弦算法得到map1中文件的词频的平方和
        for (String key : map1.keySet()) {
            sum1= sum1+Math.pow(map1.get(key),2);
        }
        //通过使用余弦算法得到map2中文件的词频的平方和
        for (String key : map2.keySet()) {
            sum2= sum2+Math.pow(map2.get(key),2);
        }
        for (String key1 : map1.keySet()) {
            for(String key2:map2.keySet()){
                if(key1.equals(key2)){
                    sumTop=sumTop+map1.get(key1)*map2.get(key2);
                }
            }
        }
        result = sumTop/(Math.sqrt(sum1)*Math.sqrt(sum2));
        return result;
    }

    //hanlp分词
    public  HashMap<String, Integer> hanlp(String pathname1) throws FileNotFoundException{
        HashMap<String, Integer> counter = new HashMap<String, Integer>();
        File file = new File( pathname1);
        Scanner sc = new Scanner(file, "utf-8");
        //遍历文件，使用HanLP分词法分词
        while(sc.hasNextLine()){
            //Hanlp分词将每一行中的词分出来，并存入List集合中
            List<Term> segmentlist= HanLP.segment(sc.nextLine());
            CoreStopWordDictionary.apply(segmentlist);//停用词
            for(Term term: segmentlist){
                Hashadd(counter,term.word);
            }
        }
        return counter;
    }

    public void Hashadd(HashMap<String, Integer> counter, String word) {
        if(counter.containsKey(word)) {//使用containsKey判断counter是否是否包含指定的键名
            int value =counter.get(word);//如果包含，获取counter中包含此键的value
            counter.put(word,value+1);//将获取到的键值加入到counter中，且将value+1
        }else counter.put(word,1);//如果不存在，将其键值加入到counter中，将value值设为1

    }
}
