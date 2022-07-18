package com.bamboo.module_test2.test12_enum;

public enum EDay {
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期天");

    private String desc;

    EDay(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return desc;
    }

}
