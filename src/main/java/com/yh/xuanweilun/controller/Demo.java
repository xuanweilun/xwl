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
        p.setHeadPic("https://googleads.g.doubleclick.net/pagead/ads?client=ca-pub-1076724771190722&output=html&h=250&slotname=1894159733&adk=3706751524&adf=551471880&w=300&lmt=1592879652&psa=1&guci=2.2.0.0.2.2.0.0&format=300x250&url=https%3A%2F%2Fblog.csdn.net%2FQ_MUMU%2Farticle%2Fdetails%2F85101498&flash=29.0.0&wgl=1&adsid=NT&dt=1592879651742&bpp=51&bdt=273&idt=649&shv=r20200618&cbv=r20190131&ptt=9&saldr=aa&abxe=1&cookie=ID%3D5f9249709b199b82%3AT%3D1590734456%3AS%3DALNI_MaqCP6-_HzTWiLaCeRB-x8aoKDjaQ&correlator=5485406532205&frm=20&pv=2&ga_vid=154364981.1592879652&ga_sid=1592879652&ga_hid=764105331&ga_fc=0&iag=0&icsg=46729378398208&dssz=55&mdo=0&mso=8&u_tz=480&u_his=1&u_java=0&u_h=720&u_w=1280&u_ah=680&u_aw=1280&u_cd=24&u_nplug=3&u_nmime=4&adx=102&ady=1875&biw=1263&bih=575&scr_x=0&scr_y=0&oid=3&pvsid=3052095848028661&pem=631&ref=https%3A%2F%2Fwww.baidu.com%2Flink%3Furl%3DiKUwk6m5Fmr7I4sY9odqbE8UaQy9EjESfTYSirWOPBJ5jeP1tPGoHYzlg4qvjPTdg21TGNLxFjl8xDJGgf00oK%26wd%3D%26eqid%3D9c4b2bde00199bfa000000065ef16a18&rx=0&eae=0&fc=896&brdim=0%2C0%2C0%2C0%2C1280%2C0%2C1280%2C680%2C1280%2C575&vis=1&rsz=%7C%7CpeEbr%7C&abl=CS&pfx=0&fu=8216&bc=31&ifi=2&uci=a!2&btvi=1&fsb=1&xpc=7vQIXfS7Kb&p=https%3A//blog.csdn.net&dtd=668");
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
