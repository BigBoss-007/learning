package com.example.demo00twodbsource.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashMap;

/**
 * 多数据源配置
 *
 * @Author sherry
 * @Description
 * @Date Create in 2018/8/10
 * @Modified By:
 */
@Configuration
@EnableTransactionManagement
public class MultiDataSourceConfig {

    /**
     * 主数据源
     *
     * @return
     */
    @Bean
//    @Primary
    @ConfigurationProperties(prefix = "app.datasource.one")
    public MutiDataSourceProperties dataSourceOne() {
        return new MutiDataSourceProperties();
    }

    /**
     * 第二数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.two")
    public MutiDataSourceProperties dataSourceTwo() {
        return new MutiDataSourceProperties();
    }

    /**
     * 第二数据源
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "app.datasource.three")
    public MutiDataSourceProperties dataSourceThree() {
        return new MutiDataSourceProperties();
    }


    /**
     * 多数据源连接池配置
     */
    @Bean
    @Primary
    public DynamicDataSource dataSource(MutiDataSourceProperties dataSourceOne
            , MutiDataSourceProperties dataSourceTwo
            , MutiDataSourceProperties dataSourceThree) {

        HikariDataSource dataSource1 = this.dataSourceConf(dataSourceOne);
        HikariDataSource dataSource2 = this.dataSourceConf(dataSourceTwo);
        HikariDataSource dataSource3 = this.dataSourceConf(dataSourceThree);

        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(dataSourceOne.getName(), dataSource1);
        hashMap.put(dataSourceTwo.getName(), dataSource2);
        hashMap.put(dataSourceThree.getName(), dataSource3);
        dynamicDataSource.setTargetDataSources(hashMap);
        dynamicDataSource.setDefaultTargetDataSource(dataSource1);
        return dynamicDataSource;
    }

    /**
     * 事务配置
     *
     * @author stylefeng
     * @Date 2018/6/27 23:11
     */
    @Bean
    @ConditionalOnMissingBean
    public DataSourceTransactionManager dataSourceTransactionManager(DynamicDataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    private HikariDataSource dataSourceConf(MutiDataSourceProperties dataSource) {
        //数据源配置信息
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(dataSource.getUrl());
        hikariConfig.setUsername(dataSource.getUsername());
        hikariConfig.setPassword(dataSource.getPassword());
        hikariConfig.setDriverClassName(dataSource.getDriverClassName());
        hikariConfig.setConnectionTestQuery("SELECT 'X'");

        System.out.println("配置数据源："+dataSource.getName());

        //初始化数据源
        HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
        return hikariDataSource;
    }
}