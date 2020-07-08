package com.yh.xuanweilun.controller;

import com.yh.xuanweilun.controller.res.AjaxRes;
import com.yh.xuanweilun.controller.res.Person;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestControllerTest {

    @PostMapping("/save/person")
    public AjaxRes savePerson(@RequestBody(required = false) Person person) {
        return AjaxRes.data(this.getPerson(),"保存成功！");
    }

    @PostMapping("/del/person/{personId}")
    public AjaxRes delPerson(@PathVariable String personId) {
        return new AjaxRes(true, "del person success", null);
    }

    @PostMapping("/update/person/{personId}")
    public AjaxRes updatePerson(@PathVariable String personId) {
        return new AjaxRes(true, "update person success", getPerson());
    }

    @GetMapping("/get/person/{personId}")
    public AjaxRes getPerson(@PathVariable String personId) {
        return new AjaxRes(true, "get person success", getPerson());
    }

    private Person getPerson() {
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
        return p;
    }
}
