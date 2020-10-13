package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/{id}")
    public String hello(@PathVariable  int id) {
        String sql = "SELECT title FROM tasks WHERE TASK_ID = ?";
        String dbString= (String) jdbcTemplate.queryForObject(
                sql,
                new Object[]{id},
                String.class);
        return "From Spring 2: " + dbString;

    }
}
