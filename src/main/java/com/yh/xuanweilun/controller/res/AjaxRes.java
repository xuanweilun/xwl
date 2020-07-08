package com.yh.xuanweilun.controller.res;

public class AjaxRes {
    private boolean success;
    private String msg;
    private Object data;

    public AjaxRes() {
    }

    public AjaxRes(boolean success, String msg, Object data) {
        this.success = success;
        this.msg = msg;
        this.data = data;
    }

    public static AjaxRes msg(String message){
        return new AjaxRes(false,message,null);
    }
    public static AjaxRes data(Object data,String message){
        return new AjaxRes(true,message,data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
