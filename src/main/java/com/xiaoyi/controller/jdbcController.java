package com.xiaoyi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class jdbcController {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @GetMapping("userList")
    public List<Map<String,Object>> userlist(){
        String sql = "select * from user";
        List<Map<String, Object>>  list_maps = jdbcTemplate.queryForList(sql);
        return list_maps;
    }
    @GetMapping("/addUser")
    public String add(){
        String sql = "insert into mybatis.user(id,name,pwd) values (9,'yyyy',3333)";
        jdbcTemplate.update(sql);
        return "update-ok";
    }
    @GetMapping("/updateUser/{id}")
    public String update(@PathVariable("id") int id){
        String sql = "update mybatis.user set name = ?,pwd = ? where id ="+id;
        Object[] objects = new Object[2];
        objects[0] = "xi";
        objects[1] = "1111";
        jdbcTemplate.update(sql,objects);
        return "update-ok";

    }
}
