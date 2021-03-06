package com.yaoxun.dynamic.rw.datasource;

/**
 * 存储当前线程使用的数据源类型
 * @author Loren
 * @date 2017年4月19日 下午5:22:29
 */
public class DynamicDataSourceHolder {

	// 使用ThreadLocal记录当前线程的数据源key
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	/**
	 * 设置数据源key
	 * 
	 * @param key
	 */
	public static void setDataSourceKey(String key) {
		holder.set(key);
	}

	/**
	 * 获取数据源key
	 * 
	 * @return
	 */
	public static String getDataSourceKey() {
		return holder.get();
	}

	// 为避免线程池没有及时回收，而造成的内存溢出问题
	public static void remove() {
		holder.remove();
	}

}
