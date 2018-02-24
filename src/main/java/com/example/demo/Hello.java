package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bo.EmployeeBO;
import com.example.demo.dao.IEmployeeDAO;
import com.example.demo.repository.EmployeeRepository;

@Controller
public class Hello {
	
	@Autowired
	private IEmployeeDAO dao;
	
	@Autowired
	private EmployeeRepository respository;
	
	@RequestMapping("/")
	public String hello() {
		dao.listEmployee();
		EmployeeBO emp = new EmployeeBO();
		emp.setName("ccc");
		emp.setGender("x");
		respository.save(emp);
		
		
		return "hello";
	}
	
	
	
}
