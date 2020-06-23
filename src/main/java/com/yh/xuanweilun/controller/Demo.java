package com.yh.xuanweilun.controller;

import com.yh.xuanweilun.controller.res.AjaxRes;
import com.yh.xuanweilun.controller.res.Person;
import com.yh.xuanweilun.entity.EquityTypeDTO;
import com.yh.xuanweilun.utils.ExcelResult;
import com.yh.xuanweilun.utils.ExcelTools;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

@RestController
public class Demo {

    private String name = "zhangfei";

    @GetMapping("/person/{personId}")
    public AjaxRes getName(@PathVariable String personId){
        System.out.println("name = " + name);
        Person p = new Person();
        p.setId("1");
        p.setName("禤为论");
        p.setAge(23);
        p.setHabit("footBall");
        p.setHeadPic("https://ss0.bdstatic.com/94oJfD_bAAcT8t7mm9GUKT-xh_/timg?" +
                "image&quality=100&size=b4000_4000&sec=1592895852&di=acb59bb8cbacc" +
                "425e95280b30361fd61&src=http://a3.att.hudong.com/14/75/013000001641" +
                "86121366756803686.jpg");
        p.setMarry(false);

        return new AjaxRes(true,"查询成功",p);
    }

    @PostMapping("/person")
    public AjaxRes savePerson(@RequestBody Person person){
        System.out.println("person = " + person);
        return new AjaxRes(true,"保存成功",person);
    }

    @DeleteMapping("/person/{personId}")
    public AjaxRes deletePerson(@PathVariable String personId){
        System.out.println("personId = " + personId);
        return new AjaxRes(true,"删除成功",null);
    }

    @PutMapping("/person/{personId}")
    public AjaxRes editPerson(@PathVariable String personId,@RequestBody Person person){
        System.out.println("personId = " + personId + ", person = " + person);
        return new AjaxRes(true,"修改成功",person);
    }

}
