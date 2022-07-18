package com.bamboo.module_test2.test11_multilanguage;

public enum ELanguageType {
    English("英语", "en", 0),
    SimplifiedChinese("简体中文","zh_CN",1),
    TraditionalChinese("繁体中文", "zh_TW",2),
    Korea("韩语", "ko",3);

    private final String desc;
    private final String type;
    private final int index;

    ELanguageType(String desc, String type, int index){
        this.desc = desc;
        this.type = type;
        this.index = index;
    }

    public String getDesc() {
        return desc;
    }

    public String getType() {
        return type;
    }

    public int getIndex() {
        return index;
    }


}
