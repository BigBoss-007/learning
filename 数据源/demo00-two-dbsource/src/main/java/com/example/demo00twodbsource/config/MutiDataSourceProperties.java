package com.example.demo00twodbsource.config;

/**
 * 多数据源的配置信息
 *
 * @Author sherry
 * @Description
 * @Date Create in 2018/8/10
 * @Modified By:
 */

public class MutiDataSourceProperties {

    private String driverClassName = "com.mysql.cj.jdbc.Driver";
    private String username;
    private String password;
    private String url;
    //数据源名称
    private String name;

    private String[] dataSourceNames = new String[]{
            "one",
            "two",
            "three"
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String[] getDataSourceNames() {
        return dataSourceNames;
    }
}