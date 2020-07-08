package com.yh.xuanweilun.controller;

import com.yh.xuanweilun.controller.res.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @GetMapping("/tables")
    public TableRes editPerson(@RequestParam(required = false) int page, @RequestParam(required = false,defaultValue = "100") int limit){
        List<LayTable> list = this.getList(limit);
        if(null == list || list.isEmpty()){
            return TableRes.ofZeroMsg();
        }
        return TableRes.ofData(list,1000);
//        return TableRes.ofZeroMsg();
    }

    @PostMapping("/pic")
    public PicRes getResult(@RequestParam MultipartFile file){
        System.out.println("file = " + file.getOriginalFilename());
        List list = new ArrayList();
        list.add("12231432");
        return new PicRes("1",list,"c恒功");
    }

    private List<LayTable> getList(int limit) {
        List<LayTable> list = new ArrayList<>();
        for (int i = 0; i < limit; i++) {
            LayTable layTable = new LayTable();
            layTable.setId(i);
            layTable.setUsername("user-"+i);
            layTable.setSex("女");
            layTable.setCity("南宁");
            layTable.setSign("(●'◡'●)");
            layTable.setExperience(200);
            layTable.setLogins(20);
            layTable.setWealth(19023909);
            layTable.setClassify("作曲家");
            layTable.setScore(100);
            list.add(layTable);
        }
        return list;
    }

    private Map<String,Object> getTables(String code, String msg, Object data, String count){
        Map<String,Object> tables = new HashMap<>();
        tables.put("code",code);
        tables.put("msg",msg);
        tables.put("data",data);
        tables.put("count",count);
        return tables;
    }

}
