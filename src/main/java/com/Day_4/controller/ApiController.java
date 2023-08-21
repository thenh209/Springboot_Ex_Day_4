package com.Day_4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Day_4.model.Student;
import com.Day_4.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService aser;
	
	@PostMapping("addstudent")
	public Student add(@RequestBody  Student s)
	{
		return aser.saveinfo(s);
	}
	
	@GetMapping("showdetails")
	public List<Student> show()
	{
		return aser.showinfo();
	}
}
