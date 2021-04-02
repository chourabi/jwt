package com.javainuse.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.config.JwtTokenUtil;
import com.javainuse.entitys.Employee;
import com.javainuse.repository.EmployeeRepository;

import io.jsonwebtoken.ExpiredJwtException;


@RestController @CrossOrigin(origins = "*")
@RequestMapping("/app")

public class HelloWorldController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	
	
	@Autowired
	 private EmployeeRepository employeeRepository;
	
	
	
	@GetMapping("/employees")
	 public List<Employee> getAllEmployees() {
	 return employeeRepository.findAll();
	 }

}