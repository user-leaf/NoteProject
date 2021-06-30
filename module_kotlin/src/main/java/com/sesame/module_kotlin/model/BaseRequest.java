package com.sesame.module_kotlin.model;

public class BaseRequest<T> {

    public String resultcode;
    public String reason;
    public T result;
    public int error_code;

}
