package com.yh.xuanweilun.controller;

import com.yh.xuanweilun.controller.res.AjaxRes;
import com.yh.xuanweilun.controller.res.Person;
import com.yh.xuanweilun.entity.EquityTypeDTO;
import com.yh.xuanweilun.utils.ExcelResult;
import com.yh.xuanweilun.utils.ExcelTools;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
public class Demo {

    private String name = "zhangfei";

    @GetMapping("/name")
    public AjaxRes getName(@RequestParam Object name){
        System.out.println("name = " + name);
        Person p = new Person("小苹果",19);
        p.setImgSrc("https://goss.veer.com/creative/vcg/veer/800water/veer-164919552.jpg");
        return new AjaxRes(true,"查询成功",p);
    }

}
