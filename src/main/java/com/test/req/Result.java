package com.test.req;

public class Result<T> {

    private T data;
    private String res;
    private Integer code;

    public  Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode(200);
        result.setRes("");
        result.setData(data);
        return result;
    }

    public Result<T> fail(String  reason){
        Result<T> result = new Result<>();
        result.setCode(10001);
        result.setRes(reason);
        result.setData(data);
        return result;
    }

    public Result() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
