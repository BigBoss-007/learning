package com.example.demo00twodbsource.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @Author sherry
 * @Description
 * @Date Create in 2019-01-11
 * @Modified By:
 */

public class DynamicDataSource extends AbstractRoutingDataSource {
    /**
     * Determine the current lookup key. This will typically be
     * implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs
     * to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    @Override
    protected Object determineCurrentLookupKey() {
        String name = DataSourceContextHolder.getDataSourceType();
        System.out.println("当前使用的数据源：" + name);
        return DataSourceContextHolder.getDataSourceType();
    }
}