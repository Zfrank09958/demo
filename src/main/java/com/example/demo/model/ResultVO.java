package com.example.demo.model;

public class ResultVO {
    private int code;
    private String msg;
    private Object data;

    public ResultVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResultVO success(Object data) {
        return new ResultVO(0, "success", data);
    }

    public static ResultVO error(String msg) {
        return new ResultVO(1, msg, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
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
