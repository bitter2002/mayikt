package com.mayikt;

import com.mayikt.entity.MayiktUserEntity;

import java.util.List;

public class Result {
    private Integer code;
    private String msg;
    private List<MayiktUserEntity> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<MayiktUserEntity> getData() {
        return data;
    }

    public void setData(List<MayiktUserEntity> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
