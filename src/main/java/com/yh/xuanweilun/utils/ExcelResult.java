package com.yh.xuanweilun.utils;

public class ExcelResult {
    private boolean success;
    private String errMsg;
    private Object results;

    public ExcelResult(boolean success, String errMsg, Object results) {
        this.success = success;
        this.errMsg = errMsg;
        this.results = results;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Object getResults() {
        return results;
    }

    public void setResults(Object results) {
        this.results = results;
    }
}
