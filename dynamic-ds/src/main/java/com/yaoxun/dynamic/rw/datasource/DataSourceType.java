package com.yaoxun.dynamic.rw.datasource;

/**
 * 定义了数据源的类型
 * @author Loren
 * @date 2017年4月19日 下午5:21:43
 */
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
