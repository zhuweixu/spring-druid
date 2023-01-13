package com.spring.druid.Enum;

public enum DataSourceTypeEnum {

    Mysql("mysql"),
    Oracle("oracle");

    private String name;

    DataSourceTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
