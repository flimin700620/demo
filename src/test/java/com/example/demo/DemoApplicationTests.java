package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	public void dbSelect() {
		String sql = "SELECT title FROM tasks WHERE TASK_ID = 1";
		String dbString= (String) jdbcTemplate.queryForObject(
				sql,
				String.class);

		assertEquals("hello",dbString);
	}
}
