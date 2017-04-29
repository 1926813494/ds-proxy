package com.yaoxun.dynamic.rw.datasource;

/**
 * 定义了数据源的类型
 * @author Loren
 * @date 2017年4月19日 下午5:21:43
 */
public enum DataSourceType {
	/**
	 * 从配置的{@link DynamicDataSource.defaultTargetDataSource}中获取数据源
	 */
	MASTER("MASTER"),

	
    /**
     * 从配置的{@link DynamicDataSource.slaves}中轮询获取数据源	，只能用于读
     */
	SLAVE("SLAVE"),
	/**
	 * 从配置的{@link DynamicDataSource.slaves}和{@link DynamicDataSource.defaultTargetDataSource}
	 * 中随机获取数据源，只能用于读
	 */
	MASTER_SALVE("MASTER_SLAVE");

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
