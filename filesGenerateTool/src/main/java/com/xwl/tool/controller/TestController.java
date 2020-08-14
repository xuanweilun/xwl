package com.xwl.tool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {
    public ModelAndView getNames(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/sele/jsonTest.html");
        List<String> names = new ArrayList<>();
        names.add("zhangsan");
        names.add("lisi");
        names.add("wangwu");
        modelAndView.addObject("names",names);
        return modelAndView;
    }
}
