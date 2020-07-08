package com.yh.xuanweilun.controller.res;

import java.util.ArrayList;
import java.util.HashMap;

public class TableRes extends HashMap<String,Object>{

    public TableRes(int initialCapacity) {
        super(initialCapacity);
    }

    public void putData(Object data, int count) {
        this.put("code","0");
        this.put("msg","");
        this.put("count",count);
        this.put("data",data);
    }

    public void putErrMsg(String message) {
        this.put("code","1");
        this.put("msg",message);
        this.put("count","0");
        this.put("data",new ArrayList<>());
    }

    public static TableRes ofMsg(String message){
        TableRes tableRes = new TableRes(4);
        tableRes.putErrMsg(message);
        return tableRes;
    }

    public static TableRes ofData(Object data, int count){
        TableRes tableRes = new TableRes(4);
        tableRes.putData(data,count);
        return tableRes;
    }

    public static TableRes ofZeroMsg(){
        TableRes tableRes = new TableRes(4);
        tableRes.putErrMsg("无匹配记录！");
        return tableRes;
    }

}
