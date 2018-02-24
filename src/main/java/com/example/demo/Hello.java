package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.IEmployeeDAO;

@Controller
public class Hello {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@RequestMapping("/")
	public String hello() {
		dao.listEmployee();
		return "hello";
	}
	
	
	
}
