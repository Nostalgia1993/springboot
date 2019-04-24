package com.example.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {

    private String msg;

    private String code;

    private Object data;

    public Result(){
        super();
    }

    public Result(String code, Object data){
        this.code = code;
        this.data = data;
    }

    public static Result succ(Object data, String code){
        return new Result(code,data);
    }

    public static Result succ(Object data){
        Result res = new Result();
        res.setCode("00");
        res.setData(data);
        res.setMsg("操作成功");
        return res;
    }

    public static Result fail(String msg,Object data){
        Result res = new Result();
        res.setCode("10");
        res.setData(data);
        res.setMsg(msg);
        return res;
    }

}
