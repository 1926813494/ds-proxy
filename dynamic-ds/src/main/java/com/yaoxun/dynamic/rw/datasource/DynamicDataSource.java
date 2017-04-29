package com.yaoxun.dynamic.rw.datasource;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 动态数据源的实现类
 * @author Loren
 * @date 2017年4月19日 下午5:22:03
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicDataSource.class);
	
	private Random random = new Random();
	
	private int slaveCount;
	
	private int masterSlaveCount;
	  
    // 轮询计数,初始为-1,AtomicInteger是线程安全的  
    private AtomicInteger counter = new AtomicInteger(-1);
	
	@Override
	protected Object determineCurrentLookupKey() {
		 // 使用DynamicDataSourceHolder保证线程安全，并且得到当前线程中的数据源key
    	String dataSourceKey = DynamicDataSourceHolder.getDataSourceKey();
    	if(DataSourceType.SLAVE.getName().equals(dataSourceKey)) {
    		 Object slaveKey = getSlaveKey();
    		 LOGGER.debug("使用SLAVE方式进行,{}",dataSourceKey);
    		 return slaveKey;
    	}else if(DataSourceType.MASTER_SALVE.getName().equals(dataSourceKey)) {
    		LOGGER.debug("使用MASTER_SALVE方式进行,{}",dataSourceKey);
    		return getMasterSlaveKey(dataSourceKey);
    	}
    	//为避免线程池没有及时回收，而造成的内存溢出问题
    	DynamicDataSourceHolder.remove();
        return dataSourceKey;
	}
	
	public void setSlaves(List<Object> slaveDatasources) {
		if(slaveDatasources != null) {
			if(slaveDatasources.size() > 0) {
				setTargetDataSources(initSlaves(slaveDatasources));
				this.slaveCount = slaveDatasources.size();
				this.masterSlaveCount = slaveDatasources.size() + 1;
			}
		}else {
			throw new IllegalArgumentException("properties slaves is required");
		}
	}
	
	/**
	 * 随机获取主数据源或从数据源
	 * @param dataSourceKey
	 * @return
	 */
	private Object getMasterSlaveKey(String dataSourceKey) {
		int nextInt = random.nextInt(masterSlaveCount);
		if(nextInt < this.slaveCount) {
			return getSlaveKey();
		}
		return dataSourceKey;
	}
	
	
	
	 /** 
     * 轮询算法实现 
     *  
     * @return 
     */  
    private Object getSlaveKey() {
    	//如果只有一个从库，不需要轮询
    	if(this.slaveCount <= 1) {
    		return Integer.valueOf(0);
    	}
        // 得到的下标为：0、1、2、3…… 
        Integer index = counter.incrementAndGet() % this.slaveCount;  
        if (counter.get() > 9999) { // 以免超出Integer范围  
            counter.set(-1); // 还原
        }
        return index;
    }  
	    
	private Map<Object, Object> initSlaves(List<Object> slaveDatasources) {
		Map<Object, Object> slaves = new HashMap<>();
		int size = slaveDatasources.size();
		for(int i=0; i<size; i++) {
			slaves.put(i, slaveDatasources.get(i));
		}
		return slaves;
	}
	
}
