package com.yangjiayu.util;

import java.io.Serializable;

/**
 * Created by 86188 on 2019/8/8.
 */
public class JsonResult<T> implements Serializable {
    private static final long serialVersionUID = 2305084682109188876L;
    private Integer state;
    private String message;
    private T data;

    public JsonResult() {
    }

    public JsonResult(Integer state, T data) {
        this.state = state;
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public JsonResult(String message) {
        this.message = message;
    }

    public JsonResult(Throwable throwable) {
        this.message = throwable.getMessage();
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
