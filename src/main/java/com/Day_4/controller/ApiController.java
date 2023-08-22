package com.Day_4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Day_4.model.Student;
import com.Day_4.service.ApiService;

@RestController
public class ApiController {
	@Autowired
	ApiService aser;
	
	@PostMapping("addstudent")
	public List<Student> add(@RequestBody  List<Student> s)
	{
		return aser.saveinfo(s);
	}
	 
	@GetMapping("student/{id}")
	public ResponseEntity<Student> showDetail(@PathVariable int id) {
	    Student employee = aser.getEmployeeById(id);
	    
	    if (employee != null) {
	        return new ResponseEntity<>(employee, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@GetMapping("showdetails")
	public List<Student> show()
	{
		return aser.showinfo();
	}
	
	@PutMapping("update")
	public Student modify(@RequestBody Student s)
	{
		return aser.changeinfo(s);
	}
	
	@PutMapping("updatebyid")
	public String modifybyid(@RequestParam int id,@RequestBody Student s)
	{
		return aser.changeinfobyid(id,s);	
	}
	
//	@DeleteMapping("delete")
//	public String del(@RequestBody Student s)
//	{
//		aser.deleteinfo(s);
//	}
	
	
//	@DeleteMapping("delid/{id}")
//	public String deleteMyId(@PathVariable int id)
//	{
//		aser.deleteid(id);
//		return "Deleted Successfully";
//	}
	
	@DeleteMapping("delparamid")
	public String deleteMyParamId(@RequestParam int id)
	{
		return (aser.deleteid(id));
	}
}
