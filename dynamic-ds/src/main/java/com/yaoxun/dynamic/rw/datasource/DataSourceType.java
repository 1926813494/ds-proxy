package com.yaoxun.dynamic.rw.datasource;

public enum DataSourceType {
	//主库
    WRITE("write"),

    //从库
    READ("read");

    private DataSourceType(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
