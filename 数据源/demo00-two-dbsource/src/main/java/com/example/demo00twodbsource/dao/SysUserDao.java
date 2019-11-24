package com.example.demo00twodbsource.dao;

import com.example.demo00twodbsource.config.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author sherry
 * @Description
 * @Date Create in 2019-01-11
 * @Modified By:
 */
@Repository
public class SysUserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DataSource(name = "one")
    public int saveToOne(String name) {
        return save(name);
    }

    @DataSource(name = "two")
    public int saveToTwo(String name) {
        return save(name);
    }

    @DataSource(name = "three")
    public int saveToThree(String name) {
        return save(name);
    }

    private int save(String name) {
        String sql = "insert into sys_user (name) " +
                "values ('" + name + "')";
        int count = jdbcTemplate.update(sql);
        return count;
    }

    @DataSource(name = "two")
    public List<Map<String, Object>> query1() {
        String sql = "select * from sys_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @DataSource(name = "three")
    public List<Map<String, Object>> query2() {
        String sql = "select * from sys_user";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        return list;
    }

}