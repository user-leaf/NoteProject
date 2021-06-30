package com.sesame.module_kotlin.model;

import java.util.List;

public class BasePageInfo<T> {
    public List<T> list;
    public int totalcount;
    public int totalpage;
    public int currentpage;
    public int pagesize;
}
